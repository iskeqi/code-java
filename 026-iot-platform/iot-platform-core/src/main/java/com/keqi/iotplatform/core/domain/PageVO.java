package com.keqi.iotplatform.core.domain;

import java.util.List;

/**
 * 分页响应VO
 */
public class PageVO {

	private long total;

	private List<?> list;

	public PageVO() {
	}

	public PageVO(long total, List<?> list) {
		this.total = total;
		this.list = list;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}
