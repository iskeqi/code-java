package map;

import java.util.Objects;

/**
 * 性别枚举类
 *
 * @author keqi
 */
public enum GenderEnum {

	NONE(0, "无"),
	MAN(1, "男"),
	WOMEN(2, "女");

	private final Integer code;
	private final String codeName;

	GenderEnum(Integer code, String codeName) {
		this.code = code;
		this.codeName = codeName;
	}

	public Integer getCode() {
		return code;
	}

	public String getCodeName() {
		return codeName;
	}

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
