package com.keqi.poster;

import java.awt.*;

/**
 * 待写进图片上的文本字符串内容
 */
public class StringContent {
	/**
	 * 文本内容使用的字体
	 */
	private Font font;

	/**
	 * 文本内容的颜色
	 */
	private Color color;

	/**
	 * 距离图片顶点的宽度
	 */
	private Integer x;

	/**
	 * 距离图片顶点的高度
	 */
	private Integer y;

	/**
	 * 文本内容
	 */
	private String value;

	/**
	 * 是否需要根据图片宽度换行展示内容
	 */
	private boolean wrap;

	/**
	 * 图片可容纳的最大文本宽度
	 */
	private Integer maxWidth;

	public StringContent() {
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getWrap() {
		return wrap;
	}

	public void setWrap(boolean wrap) {
		this.wrap = wrap;
	}

	public Integer getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(Integer maxWidth) {
		this.maxWidth = maxWidth;
	}
}
