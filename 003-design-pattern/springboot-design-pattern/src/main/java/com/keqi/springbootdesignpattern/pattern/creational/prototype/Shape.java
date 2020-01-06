package com.keqi.springbootdesignpattern.pattern.creational.prototype;

public abstract class Shape implements Cloneable {

	/*
		Cloneable接口是一个空接口，可见只是作为一个允许被拷贝的标记而已
	 */

	private String id;
	protected String type;

	// 抽象方法
	abstract void draw();

	public String getType(){
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// 克隆对象的方法
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
}
