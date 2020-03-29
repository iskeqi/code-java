package com.keqi.iotplatform.core.constant;

/**
 * 启用/禁用枚举类
 */
public enum ActiveFlagEnum implements BaseEnumInterface {

	Y("启用"),

	N("禁用");

	private String valueName;

	ActiveFlagEnum(String valueName) {
		this.valueName = valueName;
	}

	@Override
	public String getValueName() {
		return valueName;
	}
}
