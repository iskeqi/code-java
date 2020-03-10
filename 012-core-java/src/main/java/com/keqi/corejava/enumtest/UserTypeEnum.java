package com.keqi.corejava.enumtest;

/**
 * 用户类型枚举类(SUPER_ADMIN：超级管理员，TENANT_ADMIN：租户管理员，COMMON_USER：普通用户)
 */
public enum UserTypeEnum {

	SUPER_ADMIN("超级管理员"),

	TENANT_ADMIN("租户管理员"),

	COMMON_USER("普通用户");

	private String msg;

	UserTypeEnum(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
