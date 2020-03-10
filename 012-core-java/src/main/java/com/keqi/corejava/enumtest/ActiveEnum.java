package com.keqi.corejava.enumtest;

/**
 * 启用状态枚举类
 */
public enum ActiveEnum {

	// 1("启用"); 这样是会报错的，枚举类无法使用字符串来作为对象名称，从这个角度来说，数据库的标识符用字符串会方便很多
	// 同时，也更加的语义化，性能也不会有多少影响

	Y("启用"),


	N("禁用");

	private String valueName;

	ActiveEnum(String valueName) {
		this.valueName = valueName;
	}

	public String getValueName() {
		return valueName;
	}
}
