package com.keqi.seed.core.pojo;

public enum DeletedEnum {

    /**
     * 已删除
     */
    YES(1),

    /**
     * 未删除
     */
    NO(0);

    private final Integer deleted;

    DeletedEnum(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getDeleted() {
        return deleted;
    }
}
