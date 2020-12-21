package com.keqi.apihu.core.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 分页响应VO（命名和 MyBatisPlus 保持一致）
 *
 * @author keqi
 */
public class PageVO<T> {

    @ApiModelProperty(value = "记录总数", example = "100")
    private long total;

    @ApiModelProperty(value = "记录列表")
    private List<T> records;

    public PageVO() {
    }

    public PageVO(long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
