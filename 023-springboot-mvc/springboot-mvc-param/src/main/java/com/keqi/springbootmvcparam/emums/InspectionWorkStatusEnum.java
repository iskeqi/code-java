package com.keqi.springbootmvcparam.emums;

public enum InspectionWorkStatusEnum {

    /**
     * TODO待处置
     */
    TODO("待处置"),

    /**
     * WAIT处置中
     */
    WAIT("处置中"),

    /**
     * CLOSE：已关闭
     */
    CLOSE("已关闭");

    private final String msg;

    InspectionWorkStatusEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
