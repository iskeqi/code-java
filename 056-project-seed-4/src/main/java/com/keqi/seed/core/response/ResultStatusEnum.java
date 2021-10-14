package com.keqi.seed.core.response;

import com.keqi.seed.sys.domain.enums.GenderEnumValidate;

import java.util.Objects;

/**
 * ResponseStatusEnum
 *
 * @author keqi
 */
public enum ResultStatusEnum {

    // 基础返回状态码
    SUCCESS("0", "success"),
    FAILURE("1", "联系技术支持"),

    // 10000 - 权限相关
    NO_AUTH("10001", "token错误/失效"),

    // 20000 - 参数相关
    PARAM_ILLEGAL("20001", "参数错误");

    /**
     * 状态码
     */
    private final String code;

    /**
     * 状态码对应描述信息
     */
    private final String codeName;

    ResultStatusEnum(String code, String codeName) {
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
}
