package com.keqi.seed.sys.domain.enums;

import com.keqi.seed.core.pojo.BaseEnumValidate;

import java.util.Objects;

/**
 * 性别枚举类
 *
 * @author keqi
 */
public enum GenderEnumValidate implements BaseEnumValidate {

    NONE("0", "未知"),
    MAN("1", "男"),
    WOMEN("2", "女");

    private final String code;
    private final String codeName;

    GenderEnumValidate(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    public String getCode() {
        return code;
    }

    public String getCodeName() {
        return codeName;
    }

    public GenderEnumValidate parse(String code) {
        GenderEnumValidate[] values = GenderEnumValidate.values();
        for (GenderEnumValidate value : values) {
            if (Objects.equals(value.getCode(), code)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public boolean existCode(String code) {
        return parse(code) != null;
    }
}
