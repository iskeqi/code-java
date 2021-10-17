package com.keqi.seed.core.response;

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
    NO_AUTH("10001", "token错误或失效"),

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

}
