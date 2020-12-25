package com.keqi;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main4 {

	/**
	 * 竖向合成
	 * 注意：该方法合成图片需要图片的宽度一样,高度不一致也可以（查阅网上知道的，实际上有时候就是不行，蓝瘦香菇。）
	 *
	 * @param files       传入的图片
	 * @param newFileName 合成图片的名称
	 */
	public static void jointPic(List<File> files, String newFileName) {
		try {
			BufferedImage[] imgs = new BufferedImage[files.size()];
			//合成图片的总高度
			int h = 0;
			for (int i = 0; i < files.size(); i++) {
				imgs[i] = ImageIO.read(files.get(i));
				h += imgs[i].getHeight();
			}
			int width = imgs[0].getWidth();
			int height = imgs[0].getHeight();
			int[] imgArray = new int[width * height];
			// 合成图片的参数 width要合成图片宽度（已第一张图片宽度为准）,h合成图片的总高度
			BufferedImage imgNew = new BufferedImage(width, h, BufferedImage.TYPE_INT_RGB);
			int _height = 0;
			for (int i = 0; i < imgs.length; i++) {
				imgs[i].getRGB(0, 0, width, height, imgArray, 0, width);
				imgNew.setRGB(0, _height, width, height, imgArray, 0, width);
				_height += imgs[i].getHeight();
			}
			File outFile = new File("C:/Users/Administrator/Desktop/001/" + newFileName);
			ImageIO.write(imgNew, "jpg", outFile);// 写图片
			System.out.println("===合并成功===");
		} catch (Exception e) {
			System.out.println("===合并失败===");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		List<File> files = new ArrayList<>();
		String newFileName = "E:\\draw-picture\\new001e.png";

		File file1 = new File("E:\\draw-picture\\images\\growth_header_bg.png");    //2295	成功
		File file2 = new File("E:\\draw-picture\\images\\growth_footer_bg.png");    //2298
		files.add(file1);
		files.add(file2);
		jointPic(files, newFileName);
	}
}
