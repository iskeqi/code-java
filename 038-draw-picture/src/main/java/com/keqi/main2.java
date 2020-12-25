package com.keqi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class main2 {

	private static final String BACKGROUND_IMG = "E:\\draw-picture\\images\\growth_header_bg.png"; // 背景图片
	private static final String result_img = "E:\\draw-picture\\haibao.png"; // 最终输出图片
	// 二维码图片
	private static final String destImagePaths = "E:\\draw-picture\\images\\growth_title.png";

	public static void main(String[] args) {
		SmUserinfo smUserinfo = new SmUserinfo();
		smUserinfo.setHeadId("E:\\draw-picture\\images\\growth_icon_user.png");
		smUserinfo.setName("张三");
		smUserinfo.setJob("销售经理");
		smUserinfo.setPhoneNum("xxxxxx");
		smUserinfo.setCompanyName("思源教育有限公司");
		drawPoster(smUserinfo, destImagePaths, result_img);
	}

	public static boolean drawPoster(SmUserinfo smUserinfo, String destImagePaths, String resultImgs) {
		try {
			long startTime = System.currentTimeMillis();
// 1. 创建画布
			BufferedImage backgroundImg = ImageIO.read(new FileInputStream(BACKGROUND_IMG));
			BufferedImage canvas = new BufferedImage(backgroundImg.getWidth(), backgroundImg.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D g = (Graphics2D) canvas.getGraphics();
// 设置抗锯齿
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

			// 2. 将头像设置为圆角
			String avatarImgs = smUserinfo.getHeadId();
			System.out.println("avatarImgs" + smUserinfo.getHeadId());
			BufferedImage avatar = ImageIO.read(new FileInputStream(destImagePaths));
			int width = 120;
			//透明底的图片
			BufferedImage newAvatar = new BufferedImage(width, width, BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D graphics = newAvatar.createGraphics();
			//把图片切成一个圓
			{
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				//留一个像素的空白区域，这个很重要，画圆的时候把这个覆盖
				int border = 1;
				//图片是一个圆型
				Ellipse2D.Double shape = new Ellipse2D.Double(border, border, width - border * 2, width - border * 2);
				//需要保留的区域
				graphics.setClip(shape);
				graphics.drawImage(avatar, border, border, width - border * 2, width - border * 2, null);
				graphics.dispose();
			}

			//在圆图外面再画一个圆
			{
				//新创建一个graphics，这样画的圆不会有锯齿
				graphics = newAvatar.createGraphics();
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				int border = 3;
				//画笔是4.5个像素，BasicStroke的使用可以查看下面的参考文档
				//使画笔时基本会像外延伸一定像素，具体可以自己使用的时候测试
				Stroke s = new BasicStroke(4.5F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
				graphics.setStroke(s);
				graphics.setColor(Color.WHITE);
				graphics.drawOval(border, border, width - border * 2, width - border * 2);
				graphics.dispose();
			}

			// 3. 将背景图和头像结合
			// 画背景
			g.drawImage(backgroundImg.getScaledInstance(backgroundImg.getWidth(), backgroundImg.getHeight(), Image.SCALE_DEFAULT), 0, 0, null);
			// 背景上画头像
			g.drawImage(newAvatar.getScaledInstance(150, 150, Image.SCALE_DEFAULT), 90, 160, null);

			// 4. 写字（昵称）
			g.setColor(Color.BLACK);
			g.setFont(new Font("黑体", Font.BOLD, 22));
			g.drawString(smUserinfo.getName(), 160, 380);

			// 5. 画字
			g.setColor(new Color(33, 33, 33, 128));
			g.setFont(new Font("宋体", Font.BOLD, 18));
			g.drawString(smUserinfo.getJob(), 160, 460);
			// 5. 画字
			g.setColor(new Color(33, 33, 33, 128));
			g.setFont(new Font("宋体", Font.BOLD, 18));
			g.drawString(smUserinfo.getPhoneNum(), 160, 510);

			// 5. 画字
			g.setColor(new Color(33, 33, 33, 128));
			g.setFont(new Font("宋体", Font.BOLD, 18));
			g.drawString(smUserinfo.getCompanyName(), 160, 570);

			//  画二维码
			String qrCodeUrl = destImagePaths;
			BufferedImage qrCodeUrls = ImageIO.read(new File(qrCodeUrl));
			g.drawImage(qrCodeUrls.getScaledInstance(200, 200, Image.SCALE_DEFAULT), 520, 380, null);

			g.dispose();
			File resultImg = new File(resultImgs);
			ImageIO.write(canvas, "png", resultImg);

			System.out.println("生成成功！");
			System.out.println("耗时: " + (System.currentTimeMillis() - startTime) / 1000.0 + "s");
			System.out.println("生成文件路径: " + resultImg.getAbsolutePath());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private static InputStream getInputStream(String fileName) {
		return main2.class.getClassLoader().getResourceAsStream(fileName);
	}
}
