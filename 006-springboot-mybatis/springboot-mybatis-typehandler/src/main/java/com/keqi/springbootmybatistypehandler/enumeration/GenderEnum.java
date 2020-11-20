package com.keqi.springbootmybatistypehandler.enumeration;

/**
 * 性别
 */
public enum GenderEnum implements BaseEnum {

    MALE(0, "男"),
    FEMALE(1, "女"),
    UNKNOW(2, "未知");

    private Integer value; // 值
    private String description; // 描述

    private GenderEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
