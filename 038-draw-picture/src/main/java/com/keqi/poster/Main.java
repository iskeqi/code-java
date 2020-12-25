package com.keqi.poster;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 皇家教育系统海报生成代码示例
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Font font = new Font("宋体", Font.PLAIN, 24);
		Color color = new Color(0, 0, 0);

		// 根据业务情况构造数据
		List<StringContent> list = new ArrayList<>();

		// 标题
		StringContent title = new StringContent();
		title.setValue("兴趣爱好");
		title.setX(100);
		title.setY(60);
		title.setFont(font);
		title.setColor(color);
		list.add(title);

		// 内容
		StringContent content = new StringContent();
		content.setValue("这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.这里是文本内容,这里是文本内容,这里是文本内容.");
		content.setX(100);
		content.setY(120);
		content.setFont(font);
		content.setColor(color);
		list.add(content);

		// 年份
		StringContent years = new StringContent();
		years.setValue("2020");
		years.setX(100);
		years.setY(230);
		years.setFont(font);
		years.setColor(color);
		list.add(years);

		// 日期
		StringContent date = new StringContent();
		date.setValue("12-25");
		date.setX(600);
		date.setY(230);
		date.setFont(font);
		date.setColor(color);
		list.add(date);

		File file = new File("E:\\draw-picture\\poster\\content.png");
		BufferedImage content1 = ImageIO.read(file);
		PosterUtil.drawStringContent(content1, list);

		BufferedImage content2 = ImageIO.read(file);
		PosterUtil.drawStringContent(content2, list);


		//ImageIO.write(bufferedImage, "png", new File("E:\\draw-picture\\poster.png"));
	}
}
