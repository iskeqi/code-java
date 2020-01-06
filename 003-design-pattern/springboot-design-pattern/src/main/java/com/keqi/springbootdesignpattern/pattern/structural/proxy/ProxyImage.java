package com.keqi.springbootdesignpattern.pattern.structural.proxy;

/**
 * 代理对象
 */
public class ProxyImage implements Image{

	/*
		代理的核心其实就是内部持有一个目标对象而已啦
	 */


	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName){
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if(realImage == null){
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}
