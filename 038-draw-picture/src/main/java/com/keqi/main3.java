package com.keqi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class main3 {

	public static void main(String[] args) {
		String backgroundPath = "E:\\draw-picture\\images\\growth_header_bg.png";
		String qrCodePath = "E:\\draw-picture\\images\\growth_title.png";
		String message01 = "扫描下方二维码，欢迎大家添加我的淘宝返利机器人";
		String message02 = "居家必备，省钱购物专属小秘书！";
		String outPutPath = "E:\\draw-picture\\main3.png";
		overlapImage(backgroundPath, qrCodePath, message01, message02, outPutPath);
	}

	public static String overlapImage(String backgroundPath, String qrCodePath, String message01, String message02, String outPutPath) {
		try {
			//设置图片大小
//            BufferedImage background = resizeImage(618,1000, ImageIO.read(new File("这里是背景图片的路径！")));
			BufferedImage background = resizeImage(1000, 618, ImageIO.read(new File(backgroundPath)));
//            BufferedImage qrCode = resizeImage(150,150,ImageIO.read(new File("这里是插入二维码图片的路径！")));
			BufferedImage qrCode = resizeImage(1000, 100, ImageIO.read(new File(qrCodePath)));
			//在背景图片中添加入需要写入的信息，例如：扫描下方二维码，欢迎大家添加我的淘宝返利机器人，居家必备，省钱购物专属小秘书！
			//String message = "扫描下方二维码，欢迎大家添加我的淘宝返利机器人，居家必备，省钱购物专属小秘书！";
			Graphics2D g = background.createGraphics();
			g.setColor(Color.white);
			g.setFont(new Font("宋体", Font.BOLD, 20));
			g.drawString(message01, 100, 190);
			g.drawString(message02, 100, 220);
			//在背景图片上添加二维码图片
			g.drawImage(qrCode, 0, 0, qrCode.getWidth(), qrCode.getHeight(), null);
			g.dispose();
//            ImageIO.write(background, "jpg", new File("这里是一个输出图片的路径"));
			ImageIO.write(background, "png", new File(outPutPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static BufferedImage resizeImage(int x, int y, BufferedImage bfi) {
		BufferedImage bufferedImage = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
		bufferedImage.getGraphics().drawImage(
				bfi.getScaledInstance(x, y, Image.SCALE_SMOOTH), 0, 0, null);
		return bufferedImage;
	}

}
