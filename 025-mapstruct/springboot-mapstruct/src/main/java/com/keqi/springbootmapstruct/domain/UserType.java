package com.keqi.springbootmapstruct.domain;

public enum UserType {

	SUPER_ADMIN("超级管理员"),

	TENANET_ADMIN("租户管理员"),

	COMMON_USER("普通用户");



	UserType(String valueName) {
		this.valueName = valueName;
	}

	private String valueName;

	public String getValueName() {
		return valueName;
	}
}
