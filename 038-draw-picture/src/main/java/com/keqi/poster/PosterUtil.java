package com.keqi.poster;

import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

/**
 * 生成海报图片工具类
 *
 * @author keqi
 */
public class PosterUtil {

	/**
	 * 向指定的图片中写入文本内容
	 *
	 * @param bufferedImage bufferedImage
	 * @param list          list
	 */
	public static void drawStringContent(BufferedImage bufferedImage, java.util.List<StringContent> list) {
		// 获取画笔
		Graphics2D graphics = bufferedImage.createGraphics();
		// 消除混叠现象，消除走样，图形保真
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		for (StringContent t : list) {
			graphics.setFont(t.getFont());
			graphics.setColor(t.getColor());
			if (Objects.equals(true, t.getWrap())) {
				// 需要换行
				FontDesignMetrics metrics = FontDesignMetrics.getMetrics(t.getFont());
				String[] rows;
				if (isChinese(t.getValue())) {
					rows = makeLineFeed(t.getValue(), metrics, t.getMaxWidth());
				} else {
					rows = makeEnLineFeed(t.getValue(), metrics, t.getMaxWidth());
				}

				int metricsHeight = t.getY();
				for (String row : rows) {
					graphics.drawString(row, t.getX(), metricsHeight);
					metricsHeight += metrics.getHeight();
				}
			} else {
				// 不需要换行
				graphics.drawString(t.getValue(), t.getX(), t.getY());
			}
		}
	}

	/**
	 * 判断字符串内容是否为中文
	 *
	 * @param content content
	 * @return r
	 */
	private static boolean isChinese(String content) {
		int strLength = content.length();
		int byteLength = content.getBytes().length;
		return strLength != byteLength;
	}

	/**
	 * 根据当前字体下每个中文字符的宽度，以及海报可容纳的最大文本宽度，对文本进行换行
	 *
	 * @param zh        zh
	 * @param metrics   metrics
	 * @param max_width max_width
	 * @return r
	 */
	private static String[] makeLineFeed(String zh, FontDesignMetrics metrics, int max_width) {
		StringBuilder sb = new StringBuilder();
		int line_width = 0;
		for (int i = 0; i < zh.length(); i++) {
			char c = zh.charAt(i);
			sb.append(c);

			// 如果主动换行则跳过
			if (sb.toString().endsWith("\n")) {
				line_width = 0;
				continue;
			}

			// FontDesignMetrics 的 charWidth() 方法可以计算字符的宽度
			int char_width = metrics.charWidth(c);
			line_width += char_width;

			// 如果当前字符的宽度加上之前字符串的已有宽度超出了海报的最大宽度，则换行
			if (line_width >= max_width - char_width) {
				line_width = 0;
				sb.append("\n");
			}
		}
		return sb.toString().split("\n");
	}

	/**
	 * 根据当前字体下每个英文字符的宽度，以及海报可容纳的最大文本宽度，对文本进行换行
	 *
	 * @param en        en
	 * @param metrics   metrics
	 * @param max_width max_width
	 * @return r
	 */
	private static String[] makeEnLineFeed(String en, FontDesignMetrics metrics, int max_width) {
		// 每个单词后追加空格
		char space = ' ';
		int spaceWidth = metrics.charWidth(space);

		// 按照空格对英文文本进行拆分
		String[] words = en.split(String.valueOf(space));
		// 利用 StringBuilder 对字符串进行修改
		StringBuilder sb = new StringBuilder();
		// 每行文本的宽度
		int len = 0;

		for (String word : words) {
			int wordWidth = metrics.stringWidth(word);
			// 叠加当前单词的宽度
			len += wordWidth;

			// 超出最大宽度，进行换行
			if (len > max_width) {
				sb.append("\n");
				sb.append(word);
				sb.append(space);

				// 下一行的起始宽度
				len = wordWidth + spaceWidth;
			} else {
				sb.append(word);
				sb.append(space);

				// 多了一个空格
				len += spaceWidth;
			}
		}
		return sb.toString().split("\n");
	}

	/**
	 * 纵向拼接一组（多张）图像
	 *
	 * @param pics    将要拼接的图像数组
	 * @param type    写入图像类型
	 * @param dst_pic 写入图像路径
	 * @return r
	 */
	public static boolean joinImageListVertical(String[] pics, String type, String dst_pic) {
		try {
			int len = pics.length;
			if (len < 1) {
				return false;
			}

			File[] src = new File[len];
			BufferedImage[] images = new BufferedImage[len];
			int[][] imageArrays = new int[len][];
			for (int i = 0; i < len; i++) {
				src[i] = new File(pics[i]);
				images[i] = ImageIO.read(src[i]);
				int width = images[i].getWidth();
				int height = images[i].getHeight();
				imageArrays[i] = new int[width * height];// 从图片中读取RGB
				imageArrays[i] = images[i].getRGB(0, 0, width, height, imageArrays[i], 0, width);
			}

			int dst_height = 0;
			int dst_width = images[0].getWidth();
			for (BufferedImage image : images) {
				dst_width = Math.max(dst_width, image.getWidth());
				dst_height += image.getHeight();
			}
			if (dst_height < 1) {
				return false;
			}

			/*
			 * 生成新图片
			 */
			BufferedImage ImageNew = new BufferedImage(dst_width, dst_height, BufferedImage.TYPE_INT_RGB);
			int height_i = 0;
			for (int i = 0; i < images.length; i++) {
				ImageNew.setRGB(0, height_i, dst_width, images[i].getHeight(), imageArrays[i], 0, dst_width);
				height_i += images[i].getHeight();
			}
			File outFile = new File(dst_pic);
			ImageIO.write(ImageNew, type, outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
