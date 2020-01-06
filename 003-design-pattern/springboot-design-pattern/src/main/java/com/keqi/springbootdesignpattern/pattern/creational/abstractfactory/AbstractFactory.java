package com.keqi.springbootdesignpattern.pattern.creational.abstractfactory;

public abstract class AbstractFactory {
	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape) ;
}
