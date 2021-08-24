package com.keqi.nettyserverhaier;

import java.util.Objects;

/**
 * 协议指令枚举类
 *
 * @author keqi
 */
public enum CommandConsumerEnum {

    /**
     * agv 取空盘
     */
    GetInEmptyPlate("GetInEmptyPlate"),

    /**
     * agv 送空盘
     */
    SendBackEmptyPlate("SendBackEmptyPlate"),

    /**
     * agv 取满盘运送到库口
     */
    GetInFullPlate("GetInFullPlate"),

    /**
     * agv 自动门口取盘到空托盘暂存区
     */
    SendOutFullPlate("SendOutFullPlate"),

    // 其他

    /**
     * DES key
     */
    DES_KEY("haierbio");

    /**
     * 响应命令成功
     */
    public static final String RESPONSE_SUCCESS = "1";

    /**
     * 响应命令失败
     */
    public static final String RESPONSE_FAILURE = "2";

    public static CommandConsumerEnum parseByCode(String code) {
        for (CommandConsumerEnum value : CommandConsumerEnum.values()) {
            if (Objects.equals(code, value.getCode())) {
                return value;
            }
        }
        return null;
    }

    private final String code;

    CommandConsumerEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
