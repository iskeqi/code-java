package com.keqi.poster;

import java.awt.image.BufferedImage;
import java.util.List;

public class PosterImage {

	private BufferedImage bufferedImage;

	private List<StringContent> list;

	public PosterImage() {
	}

	public PosterImage(BufferedImage bufferedImage, List<StringContent> list) {
		this.bufferedImage = bufferedImage;
		this.list = list;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	public List<StringContent> getList() {
		return list;
	}

	public void setList(List<StringContent> list) {
		this.list = list;
	}
}
