package com.keqi.springbootdesignpattern.pattern.structural.decorator;


public abstract class ShapeDecorator implements Shape {

	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape){
		this.decoratedShape = decoratedShape;
	}

	// 调用Shape的draw()方法
	public void draw(){
		decoratedShape.draw();
	}
}
