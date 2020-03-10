package com.keqi.spirngbootdictdb.enums;

public enum UserTypeEnum {

	SUPER_ADMIN("超级管理员"),
	COMMON_USER("普通用户");

	private String valueName;

	UserTypeEnum(String valueName) {
		this.valueName = valueName;
	}

	public String getValueName() {
		return valueName;
	}
}
