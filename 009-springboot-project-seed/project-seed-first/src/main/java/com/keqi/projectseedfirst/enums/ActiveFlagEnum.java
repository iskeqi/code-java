package com.keqi.projectseedfirst.enums;

public enum ActiveFlagEnum {

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
