package com.keqi.projectseedsecond.common;

public enum ActiveFlagEnum implements BaseEnumInterface{

	Y("启用"),

	N("禁用");

	private String valueName;

	ActiveFlagEnum(String valueName) {
		this.valueName = valueName;
	}

	public String getValueName() {
		return valueName;
	}
}
