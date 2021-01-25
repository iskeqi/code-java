package com.keqi.knife4j.core.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 命名和 PageHelper 保持一致
 */
public class PageParam {

    @ApiModelProperty(value = "前页数", example = "1", required = true)
    protected int pageNum = 1;

    @ApiModelProperty(value = "每页大小", example = "10", required = true)
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
}