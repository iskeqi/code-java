package com.keqi.seed.core.pojo;

/**
 * 命名和 MyBatisPlus 保持一致
 */
public class PageParam {

    protected long current = 1;

    protected long size = 10;

    public PageParam() {
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}