package com.keqi.springbootdesignpattern.pattern.creational.abstractfactory;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
