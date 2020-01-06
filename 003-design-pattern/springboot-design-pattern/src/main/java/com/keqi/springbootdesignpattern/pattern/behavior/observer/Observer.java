package com.keqi.springbootdesignpattern.pattern.behavior.observer;

public abstract class Observer {
	protected Subject subject;
	public abstract void update();
}
