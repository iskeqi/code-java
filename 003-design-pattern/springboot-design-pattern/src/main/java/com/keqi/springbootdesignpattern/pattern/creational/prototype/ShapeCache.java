package com.keqi.springbootdesignpattern.pattern.creational.prototype;

import java.util.Hashtable;

public class ShapeCache {

	// 该类被加载时就把每一种类型的对象创建了一份，往后每次都是直接使用对象克隆技术创建了新的对象
	private static Hashtable<String, Shape> shapeMap
			= new Hashtable<>();

	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}

	// 对每种形状都运行数据库查询，并创建该形状
	// shapeMap.put(shapeKey, shape);
	// 例如，我们要添加三种形状
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(),circle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(),square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(),rectangle);
	}
}
