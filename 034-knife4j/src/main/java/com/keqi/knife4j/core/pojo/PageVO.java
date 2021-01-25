package com.keqi.knife4j.core.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 分页响应VO（命名和 PageHelper 保持一致）
 *
 * @author keqi
 */
public class PageVO<T> {

	@ApiModelProperty(value = "记录总数", example = "1012")
	private long total;

	@ApiModelProperty(value = "记录列表")
	private List<T> list;

	public PageVO() {
	}

	public PageVO(long total, List<T> list) {
		this.total = total;
		this.list = list;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
