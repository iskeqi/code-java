package com.keqi.enmutest;

/**
 * 任务状态枚举类
 */
public enum TaskStatusEnum {

    DBL(1, "待办理"),

    BLZ(2, "办理中"),

    WKS(3, "未开始"),

    YGD(4, "已归档"),

    YSX(5, "已失效");
/*

    public static String getName(Integer code) {
        for (TaskStatusEnum value : TaskStatusEnum.values()) {
            if (code.equals(value.getCode())) {
                return value.getName();
            }
        }
        return null;
    }
*/

    TaskStatusEnum(Integer code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    private final Integer code;
    private final String codeName;

    public Integer getCode() {
        return code;
    }

    public String getCodeName() {
        return codeName;
    }
}
