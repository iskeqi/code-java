package com.keqi.poster;

import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 海报图片工具类
 *
 * @author keqi
 */
public class PosterImageUtil {

	/**
	 * content1 内容和布局
	 *
	 * @return r
	 */
	private static List<StringContent> content1Data() {
		// 根据业务情况构造数据
		List<StringContent> list = new ArrayList<>();

		// 标题
		StringContent title = new StringContent();
		Font titleFont = new Font("微软雅黑", Font.PLAIN, 60);
		Color titleColor = new Color(113, 101, 78);
		title.setValue("兴趣爱好");
		title.setX(242);
		title.setY(115);
		title.setFont(titleFont);
		title.setColor(titleColor);
		list.add(title);

		// 内容
		StringContent content = new StringContent();
		Font contentFont = new Font("宋体", Font.PLAIN, 48);
		Color contentColor = new Color(0, 0, 0);
		content.setValue("这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.");
		content.setX(242);
		content.setY(225);
		content.setFont(contentFont);
		content.setWrap(true);
		content.setMaxWidth(1154);
		content.setColor(contentColor);
		list.add(content);

		// 年份
		StringContent years = new StringContent();
		Font yearsFont = new Font("宋体", Font.PLAIN, 96);
		Color yearsColor = new Color(0, 0, 0);
		years.setValue("2020");
		years.setX(242);
		years.setY(455);
		years.setFont(yearsFont);
		years.setColor(yearsColor);
		list.add(years);

		// 日期
		StringContent date = new StringContent();
		Font dateFont = new Font("宋体", Font.PLAIN, 56);
		Color dateColor = new Color(94, 98, 106);
		date.setValue("12月25日");
		date.setX(1170);
		date.setY(445);
		date.setFont(dateFont);
		date.setColor(dateColor);
		list.add(date);

		return list;
	}

	/**
	 * content1 内容和布局
	 *
	 * @return r
	 */
	private static List<StringContent> content1EnglishData() {
		// 根据业务情况构造数据
		List<StringContent> list = new ArrayList<>();

		// 标题
		StringContent title = new StringContent();
		Font titleFont = new Font("微软雅黑", Font.PLAIN, 60);
		Color titleColor = new Color(113, 101, 78);
		title.setValue("兴趣爱好");
		title.setX(242);
		title.setY(115);
		title.setFont(titleFont);
		title.setColor(titleColor);
		list.add(title);

		// 内容
		StringContent content = new StringContent();
		Font contentFont = new Font("Consolas", Font.PLAIN, 48);
		Color contentColor = new Color(0, 0, 0);
		content.setValue("Here is text content, here is text content, here is text content. Here is text content, here is text content, here is text content. ");
		content.setX(242);
		content.setY(225);
		content.setFont(contentFont);
		content.setWrap(true);
		content.setMaxWidth(1154);
		content.setColor(contentColor);
		list.add(content);

		// 年份
		StringContent years = new StringContent();
		Font yearsFont = new Font("宋体", Font.PLAIN, 96);
		Color yearsColor = new Color(0, 0, 0);
		years.setValue("2020");
		years.setX(242);
		years.setY(455);
		years.setFont(yearsFont);
		years.setColor(yearsColor);
		list.add(years);

		// 日期
		StringContent date = new StringContent();
		Font dateFont = new Font("宋体", Font.PLAIN, 56);
		Color dateColor = new Color(94, 98, 106);
		date.setValue("12月25日");
		date.setX(1170);
		date.setY(445);
		date.setFont(dateFont);
		date.setColor(dateColor);
		list.add(date);

		return list;
	}

	/**
	 * content2 内容和布局
	 *
	 * @return r
	 */
	private static List<StringContent> content2Data() {
		// 根据业务情况构造数据
		List<StringContent> list = new ArrayList<>();

		// 标题
		StringContent title = new StringContent();
		Font titleFont = new Font("微软雅黑", Font.PLAIN, 60);
		Color titleColor = new Color(113, 101, 78);
		title.setValue("兴趣爱好");
		title.setX(242);
		title.setY(115);
		title.setFont(titleFont);
		title.setColor(titleColor);
		list.add(title);

		// 内容
		StringContent content = new StringContent();
		Font contentFont = new Font("宋体", Font.PLAIN, 48);
		Color contentColor = new Color(0, 0, 0);
		content.setValue("这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.");
		content.setX(242);
		content.setY(225);
		content.setFont(contentFont);
		content.setWrap(true);
		content.setMaxWidth(1154);
		content.setColor(contentColor);
		list.add(content);

		// 年份
		StringContent years = new StringContent();
		Font yearsFont = new Font("宋体", Font.PLAIN, 96);
		Color yearsColor = new Color(0, 0, 0);
		years.setValue("2020");
		years.setX(242);
		years.setY(610);
		years.setFont(yearsFont);
		years.setColor(yearsColor);
		list.add(years);

		// 日期
		StringContent date = new StringContent();
		Font dateFont = new Font("宋体", Font.PLAIN, 56);
		Color dateColor = new Color(94, 98, 106);
		date.setValue("12月25日");
		date.setX(1170);
		date.setY(600);
		date.setFont(dateFont);
		date.setColor(dateColor);
		list.add(date);

		return list;
	}

	/**
	 * content2 内容和布局
	 *
	 * @return r
	 */
	private static List<StringContent> content2EnglishData() {
		// 根据业务情况构造数据
		List<StringContent> list = new ArrayList<>();

		// 标题
		StringContent title = new StringContent();
		Font titleFont = new Font("微软雅黑", Font.PLAIN, 60);
		Color titleColor = new Color(113, 101, 78);
		title.setValue("兴趣爱好");
		title.setX(242);
		title.setY(115);
		title.setFont(titleFont);
		title.setColor(titleColor);
		list.add(title);

		// 内容
		StringContent content = new StringContent();
		Font contentFont = new Font("Consolas", Font.PLAIN, 48);
		Color contentColor = new Color(0, 0, 0);
		content.setValue("Here is text content, here is text content, here is text content. Here is text content, here is text content, here is text content. Here is text content, here is text content, here is text content. Here is text content, here is text content, ");
		content.setX(242);
		content.setY(225);
		content.setFont(contentFont);
		content.setWrap(true);
		content.setMaxWidth(1154);
		content.setColor(contentColor);
		list.add(content);

		// 年份
		StringContent years = new StringContent();
		Font yearsFont = new Font("宋体", Font.PLAIN, 96);
		Color yearsColor = new Color(0, 0, 0);
		years.setValue("2020");
		years.setX(242);
		years.setY(610);
		years.setFont(yearsFont);
		years.setColor(yearsColor);
		list.add(years);

		// 日期
		StringContent date = new StringContent();
		Font dateFont = new Font("宋体", Font.PLAIN, 56);
		Color dateColor = new Color(94, 98, 106);
		date.setValue("12月25日");
		date.setX(1170);
		date.setY(600);
		date.setFont(dateFont);
		date.setColor(dateColor);
		list.add(date);

		return list;
	}

	/**
	 * content3 内容和布局
	 *
	 * @return r
	 */
	private static List<StringContent> content3Data() {
		// 根据业务情况构造数据
		List<StringContent> list = new ArrayList<>();

		// 标题
		StringContent title = new StringContent();
		Font titleFont = new Font("微软雅黑", Font.PLAIN, 60);
		Color titleColor = new Color(113, 101, 78);
		title.setValue("兴趣爱好");
		title.setX(242);
		title.setY(115);
		title.setFont(titleFont);
		title.setColor(titleColor);
		list.add(title);

		// 内容
		StringContent content = new StringContent();
		Font contentFont = new Font("宋体", Font.PLAIN, 48);
		Color contentColor = new Color(0, 0, 0);
		content.setValue("这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.");
		content.setX(242);
		content.setY(225);
		content.setFont(contentFont);
		content.setWrap(true);
		content.setMaxWidth(1154);
		content.setColor(contentColor);
		list.add(content);

		// 年份
		StringContent years = new StringContent();
		Font yearsFont = new Font("宋体", Font.PLAIN, 96);
		Color yearsColor = new Color(0, 0, 0);
		years.setValue("2020");
		years.setX(242);
		years.setY(655);
		years.setFont(yearsFont);
		years.setColor(yearsColor);
		list.add(years);

		// 日期
		StringContent date = new StringContent();
		Font dateFont = new Font("宋体", Font.PLAIN, 56);
		Color dateColor = new Color(94, 98, 106);
		date.setValue("12月25日");
		date.setX(1170);
		date.setY(655);
		date.setFont(dateFont);
		date.setColor(dateColor);
		list.add(date);

		return list;
	}

	/**
	 * content3 内容和布局
	 *
	 * @return r
	 */
	private static List<StringContent> content3EnglishData() {
		// 根据业务情况构造数据
		List<StringContent> list = new ArrayList<>();

		// 标题
		StringContent title = new StringContent();
		Font titleFont = new Font("微软雅黑", Font.PLAIN, 60);
		Color titleColor = new Color(113, 101, 78);
		title.setValue("兴趣爱好");
		title.setX(242);
		title.setY(115);
		title.setFont(titleFont);
		title.setColor(titleColor);
		list.add(title);

		// 内容
		StringContent content = new StringContent();
		Font contentFont = new Font("Consolas", Font.PLAIN, 48);
		Color contentColor = new Color(0, 0, 0);
		content.setValue("Here is text content, here is text content, here is text content. Here is text content, here is text content, here is text content. Here is text content, here is text content, here is text content. Here is text content, here is text content, here is text content. Here is text content, here is text content, ");
		content.setX(242);
		content.setY(225);
		content.setFont(contentFont);
		content.setWrap(true);
		content.setMaxWidth(1154);
		content.setColor(contentColor);
		list.add(content);

		// 年份
		StringContent years = new StringContent();
		Font yearsFont = new Font("宋体", Font.PLAIN, 96);
		Color yearsColor = new Color(0, 0, 0);
		years.setValue("2020");
		years.setX(242);
		years.setY(655);
		years.setFont(yearsFont);
		years.setColor(yearsColor);
		list.add(years);

		// 日期
		StringContent date = new StringContent();
		Font dateFont = new Font("宋体", Font.PLAIN, 56);
		Color dateColor = new Color(94, 98, 106);
		date.setValue("12月25日");
		date.setX(1170);
		date.setY(655);
		date.setFont(dateFont);
		date.setColor(dateColor);
		list.add(date);

		return list;
	}

	/**
	 * head 内容和布局
	 *
	 * @return r
	 */
	private static List<StringContent> headData() {
		// 根据业务情况构造数据
		List<StringContent> list = new ArrayList<>();

		// 姓名
		StringContent years = new StringContent();
		Font yearsFont = new Font("宋体", Font.PLAIN, 48);
		Color yearsColor = new Color(94, 98, 106);
		years.setValue("刘明虎");
		years.setX(230);
		years.setY(720);
		years.setFont(yearsFont);
		years.setColor(yearsColor);
		list.add(years);

		// 类型
		StringContent date = new StringContent();
		Font dateFont = new Font("宋体", Font.PLAIN, 48);
		Color dateColor = new Color(94, 98, 106);
		date.setValue("专升本");
		date.setX(1290);
		date.setY(715);
		date.setFont(dateFont);
		date.setColor(dateColor);
		list.add(date);

		return list;
	}

	public static void main(String[] args) throws IOException {
		// 根据具体业务情况数据（使用textContentWrap()方法来决定用哪一张图）
		BufferedImage head = ImageIO.read(new File("E:\\draw-picture\\poster\\head.png"));
		BufferedImage content1 = ImageIO.read(new File("E:\\draw-picture\\poster\\content1.png"));
		BufferedImage content2 = ImageIO.read(new File("E:\\draw-picture\\poster\\content2.png"));
		BufferedImage content3 = ImageIO.read(new File("E:\\draw-picture\\poster\\content3.png"));
		BufferedImage footer = ImageIO.read(new File("E:\\draw-picture\\poster\\footer.png"));

		List<PosterImage> list = new ArrayList<>();
		list.add(new PosterImage(head, headData()));
		list.add(new PosterImage(content1, content1Data()));
		list.add(new PosterImage(content2, content2EnglishData()));
		list.add(new PosterImage(content3, content3Data()));
		list.add(new PosterImage(footer, new ArrayList<>()));

		BufferedImage bufferedImage = drawPosterImage(list);
		ImageIO.write(bufferedImage, "png", new File("E:\\draw-picture\\poster.png"));
	}

	/**
	 * 批量传入多个图片及数据，最后组装成一张单独的图片
	 *
	 * @param list list
	 * @return r
	 */
	public static BufferedImage drawPosterImage(java.util.List<PosterImage> list) {
		BufferedImage[] bufferedImages = new BufferedImage[list.size()];
		for (int i = 0; i < list.size(); i++) {
			BufferedImage bufferedImage = list.get(i).getBufferedImage();
			List<StringContent> contents = list.get(i).getList();
			drawStringContent(bufferedImage, contents);
			bufferedImages[i] = bufferedImage;
		}
		return joinImageListVertical(bufferedImages);
	}

	/**
	 * 根据当前字体下每个中文/英文字符的宽度，以及海报可容纳的最大文本宽度，对文本进行换行
	 *
	 * @param textContent textContent
	 * @param metrics     metrics
	 * @param max_width   max_width
	 * @return r
	 */
	public static String[] textContentWrap(String textContent, FontDesignMetrics metrics, int max_width) {
		if (isChinese(textContent)) {
			return makeLineFeed(textContent, metrics, max_width);
		} else {
			return makeEnLineFeed(textContent, metrics, max_width);
		}
	}

	/**
	 * 获取系统支持的字体
	 */
	public static String[] fontsSupportedByTheOS() {
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	}

	/**
	 * 向指定的图片中写入文本内容
	 *
	 * @param bufferedImage bufferedImage
	 * @param list          list
	 */
	private static void drawStringContent(BufferedImage bufferedImage, java.util.List<StringContent> list) {
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
				String[] rows = textContentWrap(t.getValue(), metrics, t.getMaxWidth());

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
		// 释放图形上下文，以及它正在使用的任何系统资源。
		graphics.dispose();
	}

	/**
	 * 纵向拼接一组（多张）图像
	 *
	 * @param images 将要拼接的图像数组
	 * @return r
	 */
	private static BufferedImage joinImageListVertical(BufferedImage[] images) {
		BufferedImage imageNew = null;
		try {
			int len = images.length;
			if (len < 1) {
				throw new RuntimeException("异常");
			}

			int[][] imageArrays = new int[len][];
			for (int i = 0; i < len; i++) {
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
				throw new RuntimeException("异常");
			}

			/*
			 * 生成新图片
			 */
			imageNew = new BufferedImage(dst_width, dst_height, BufferedImage.TYPE_INT_RGB);
			int height_i = 0;
			for (int i = 0; i < images.length; i++) {
				imageNew.setRGB(0, height_i, dst_width, images[i].getHeight(), imageArrays[i], 0, dst_width);
				height_i += images[i].getHeight();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imageNew;
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
}
