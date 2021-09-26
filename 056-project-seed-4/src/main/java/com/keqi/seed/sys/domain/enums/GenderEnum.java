package com.keqi.seed.sys.domain.enums;

import com.keqi.seed.core.pojo.BaseEnum;

import java.util.Objects;

/**
 * 性别枚举类
 *
 * @author keqi
 */
public enum GenderEnum implements BaseEnum {

    NONE("0", "未知"),
    MAN("1", "男"),
    WOMEN("2", "女");

    private final String code;
    private final String codeName;

    GenderEnum(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    @Override
    public String getCode() {
        return code;
    }

    public String getCodeName() {
        return codeName;
    }

    public GenderEnum parse(String code) {
        GenderEnum[] values = GenderEnum.values();
        for (GenderEnum value : values) {
            if (Objects.equals(value.getCode(), code)) {
                return value;
            }
        }
        return null;
    }
}
