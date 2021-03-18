package com.keqi.seed.core.pojo;

public class BaseDO {

    protected Long id;

    public BaseDO() {
    }

    public BaseDO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
