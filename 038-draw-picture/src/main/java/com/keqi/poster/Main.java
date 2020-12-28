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
 * <p>
 * 参考链接：http://www.itwanger.com/java/2019/11/14/java-qrcode-poster.html
 */
public class Main {

	public static void main(String[] args) throws IOException {

		BufferedImage head = ImageIO.read(new File("E:\\draw-picture\\poster\\head.png"));
		PosterUtil.drawStringContent(head, headData());

		BufferedImage footer = ImageIO.read(new File("E:\\draw-picture\\poster\\footer.png"));

		BufferedImage content1 = ImageIO.read(new File("E:\\draw-picture\\poster\\content1.png"));
		PosterUtil.drawStringContent(content1, content1Data());

		BufferedImage content2 = ImageIO.read(new File("E:\\draw-picture\\poster\\content2.png"));
		PosterUtil.drawStringContent(content2, content2Data());

		BufferedImage content3 = ImageIO.read(new File("E:\\draw-picture\\poster\\content3.png"));
		PosterUtil.drawStringContent(content3, content3Data());

		BufferedImage content1_1 = ImageIO.read(new File("E:\\draw-picture\\poster\\content1.png"));
		PosterUtil.drawStringContent(content1_1, content1EnglishData());
		BufferedImage content2_1 = ImageIO.read(new File("E:\\draw-picture\\poster\\content2.png"));
		PosterUtil.drawStringContent(content2_1, content2EnglishData());
		BufferedImage content3_1 = ImageIO.read(new File("E:\\draw-picture\\poster\\content3.png"));
		PosterUtil.drawStringContent(content3_1, content3EnglishData());

		BufferedImage[] images = new BufferedImage[8];
		images[0] = head;
		images[1] = content1;
		images[2] = content2;
		images[3] = content3;
		images[4] = content1_1;
		images[5] = content2_1;
		images[6] = content3_1;
		images[7] = footer;

		ImageUtil.joinImageListVertical(images, "png", "E:\\draw-picture\\poster.png");
	}

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
}
