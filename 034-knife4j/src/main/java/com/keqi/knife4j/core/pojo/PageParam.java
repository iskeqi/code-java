package com.keqi.knife4j.core.pojo;

import io.swagger.annotations.ApiModelProperty;

public class PageParam {

	@ApiModelProperty(value = "前页数", example = "1", required = true)
	protected int current = 1;

	@ApiModelProperty(value = "每页大小", example = "10", required = true)
	protected int size = 10;

	public PageParam() {
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}