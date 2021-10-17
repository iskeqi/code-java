package com.keqi.springbootspringvalidator.domain;

public enum Sex implements BaseEnum {

    MAN("male", "男性"),

    WOMEN("girl", "女性");

    private final String code;
    private final String codeName;

    Sex(String code, String codeName) {
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

    public static Sex parse(String code) {
        for (Sex value : Sex.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
