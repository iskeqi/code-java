package com.keqi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class main1 {
	public static void main(String[] args) {
		test2();
	}

	public static void test1() {
		int imageWidth = 128;//图片的宽度
		int imageHeight = 64;//图片的高度
		BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		try {
			Font font = new Font("新宋体", Font.PLAIN, 12);
			graphics.setFont(font);
			graphics.fillRect(0, 0, imageWidth, imageHeight);
			graphics.setColor(new Color(0, 0, 0));//设置黑色字体,同样可以graphics.setColor(Color.black);
			graphics.drawString("产品：深圳雅辉呼叫器", 0, 10);
			graphics.drawString("网址:www.szsyhaf.com", 0, 36);
			ImageIO.write(image, "PNG", new File("E:\\draw-picture\\test1.png"));//生成图片方法一
			//ImageIO,可以生成不同格式的图片，比如JPG,PNG,GIF.....
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//生成图片方法二开始,只知道生成jpg格式的图片,这个方法其他格式的还是不知道怎么弄。
		/*try {
			FileOutputStream fos = new FileOutputStream("D:\\abc.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
			encoder.encode(image);
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//生成图片方法二结束
		graphics.dispose();//释放资源
	}

	public static void test2() {
		try
		{
			int width = 128;
			int height = 64;
			// 创建BufferedImage对象
			Font font=new Font("宋体",Font.PLAIN,16);
			BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
			// 获取Graphics2D
			Graphics2D g2d = image.createGraphics();
			// 画图
			g2d.setBackground(new Color(255,255,255));
			g2d.setPaint(new Color(0,0,0));
			g2d.clearRect(0, 0, width, height);
			g2d.drawString("名称：娃哈哈纯净水",0,10);
			g2d.drawString("产地：浙江杭州",0,26);
			g2d.drawString("品牌：娃娃哈哈",0,42);
			g2d.drawString("单价：9876543210",0,58);
			g2d.setFont(font);
			//释放对象
			g2d.dispose();
			// 保存文件
			ImageIO.write(image, "png", new File("E:\\draw-picture\\test2.png"));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
}
