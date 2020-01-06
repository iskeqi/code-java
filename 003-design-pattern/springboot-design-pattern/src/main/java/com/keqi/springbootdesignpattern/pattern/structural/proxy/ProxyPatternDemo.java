package com.keqi.springbootdesignpattern.pattern.structural.proxy;

/**
 * 代理模式
 */
public class ProxyPatternDemo {

	/*
		所谓代理模式就是创建一个代理对象来代表真正的对象，对外提供服务，可以增强或者减少功能。

		类似于，电视剧里面的那些大佬找一个替死鬼替代自己出去办事一样


	 */


	public static void main(String[] args) {

		Image image = new ProxyImage("test_10mb.jpg");

		// 图像将从磁盘加载
		image.display();
		System.out.println("----------");

		// 图像不需要从磁盘加载,因为前面已经加载过了
		image.display();
	}
}
