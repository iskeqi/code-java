package com.keqi.poster;

import sun.font.FontDesignMetrics;

import java.awt.*;
import java.awt.image.BufferedImage;
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
				if (ImageUtil.isChinese(t.getValue())) {
					rows = ImageUtil.makeLineFeed(t.getValue(), metrics, t.getMaxWidth());
				} else {
					rows = ImageUtil.makeEnLineFeed(t.getValue(), metrics, t.getMaxWidth());
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
		// 释放图形上下文，以及它正在使用的任何系统资源。
		graphics.dispose();
	}


}
