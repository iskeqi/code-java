package com.keqi.springbootdesignpattern.pattern.creational.prototype;

/**
 * 原型模式
 */
public class PrototypePatternDemo {

	/*
		如果想要重复的创建相同的对象，可以使用原型模式，其实spring中创建原型对象就是这种方式呀

		这里的实现方式是，程序启动时就先创建所有的对象，作为一个备份。之后每次需要重新创建对象时，就使用克隆技术快速复制一个副本对象出来

		这里其实涉及到了JAVA的一个知识点，即对象的深拷贝和浅拷贝

	 */

	public static void main(String[] args) {
		ShapeCache.loadCache();

		Shape clonedShape = (Shape) ShapeCache.getShape("1");
		System.out.println("Shape : " + clonedShape.getType() + " " + clonedShape.hashCode());
		System.out.println("Shape : " + clonedShape.getType() + " " + clonedShape.hashCode());

		Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
		System.out.println("Shape : " + clonedShape2.getType() + " " + clonedShape2.hashCode());
		System.out.println("Shape : " + clonedShape2.getType() + " " + clonedShape2.hashCode());

		Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
		System.out.println("Shape : " + clonedShape3.getType()+ " " + clonedShape3.hashCode());
		System.out.println("Shape : " + clonedShape3.getType()+ " " + clonedShape3.hashCode());
	}
}
