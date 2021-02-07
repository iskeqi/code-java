package com.keqi.springbootmybatisbase.core.pojo;

/**
 * 命名和 PageHelper 保持一致
 */
public class PageParam {

    protected int pageNum = 1;

    protected int pageSize = 10;

    public PageParam() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return (this.pageNum - 1) * this.pageSize;
    }
}