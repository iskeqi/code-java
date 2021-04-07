package com.keqi.springbootmvcjackson.enums;

/**
 * 性别枚举类
 */
public enum GenderEnum implements BaseEnum {

	MAN(1, "男"),
	WOMEN(2, "女");

	private final Integer code;
	private final String codeName;

	GenderEnum(Integer code, String codeName) {
		this.code = code;
		this.codeName = codeName;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getCodeName() {
		return codeName;
	}
}
