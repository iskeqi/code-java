package com.keqi.springbootspringvalidator.domain;

public enum Gender implements BaseEnum {

    MAN("man", "男性"),

    WOMEN("women", "女性");

    private final String code;
    private final String codeName;

    Gender(String code, String codeName) {
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

    public static Gender parse(String code) {
        for (Gender value : Gender.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
