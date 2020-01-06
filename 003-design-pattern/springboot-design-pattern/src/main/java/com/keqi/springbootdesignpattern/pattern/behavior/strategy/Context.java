package com.keqi.springbootdesignpattern.pattern.behavior.strategy;

/**
 * 策略模式的核心类
 */
public class Context {

	/*
		这个类里面决定具体使用哪个策略模式哦

	 */

	private Strategy strategy;

	public Context(Strategy strategy){
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2){
		return strategy.doOperation(num1, num2);
	}
}
