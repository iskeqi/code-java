package com.keqi.seed.demo.domain.enums;

import com.keqi.seed.core.pojo.BaseEnum;

import java.util.Objects;

/**
 * 性别枚举类
 *
 * @author keqi
 */
public enum GenderEnum implements BaseEnum<GenderEnum> {

	NONE(0, "无"),
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

	@Override
	public GenderEnum buildByCode(Integer code) {
		GenderEnum[] values = GenderEnum.values();
		for (GenderEnum value : values) {
			if (Objects.equals(value.getCode(), code)) {
				return value;
			}
		}
		return null;
	}
}
