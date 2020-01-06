package com.keqi.springbootdesignpattern.pattern.structural.decorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	// 无非就是持有了目标对象的引用，和代理模式区别真不大

	// 重写了父类的方法，调用了Shape的draw()方法，还调用了自己内部的setRedBorder()方法
	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(Shape decoratedShape){
		System.out.println("Border Color: Red");
	}
}
