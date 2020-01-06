package com.keqi.springbootdesignpattern.pattern.creational.builder;

public class Bottle implements Packing {

	@Override
	public String pack() {
		return "Bottle";
	}
}
