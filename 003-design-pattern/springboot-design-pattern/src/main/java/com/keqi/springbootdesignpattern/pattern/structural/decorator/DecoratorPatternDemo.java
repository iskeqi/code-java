package com.keqi.springbootdesignpattern.pattern.structural.decorator;

/**
 * 装饰器模式
 */
public class DecoratorPatternDemo {

	/*
		何种装饰器模式和代理模式感觉也没啥区别啊，不也是搞一个类来包装原来的类吗，有啥不一样，
		不还是那么回事


	 */

	public static void main(String[] args) {

		Shape circle = new Circle();
		ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
		ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
		//Shape redCircle = new RedShapeDecorator(new Circle());
		//Shape redRectangle = new RedShapeDecorator(new Rectangle());
		// 原始对象的方法
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}
