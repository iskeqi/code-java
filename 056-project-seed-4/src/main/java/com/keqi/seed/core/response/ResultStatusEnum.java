package com.keqi.seed.core.response;

/**
 * ResponseStatusEnum
 *
 * @author keqi
 */
public enum ResultStatusEnum {

    SUCCESS("00000", "success"),

    // 用户端错误
    NO_AUTH("A0001", "token错误或失效"),
    PARAM_ILLEGAL("A0002", "参数错误"),

    // 服务端错误
    FAILURE("B0001", "联系技术支持"),

    // 第三方服务错误
    THIRD_SERVICE("C0001", "调用第三方服务出错");

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
