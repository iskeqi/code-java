package com.keqi.knife4j.core.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageParam {

	@ApiModelProperty(value = "前页数", example = "1", required = true)
	protected int current = 1;

	@ApiModelProperty(value = "每页大小", example = "10", required = true)
	protected int size = 10;
}