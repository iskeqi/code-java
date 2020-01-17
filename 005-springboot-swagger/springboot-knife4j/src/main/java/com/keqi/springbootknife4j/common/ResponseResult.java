package com.keqi.springbootknife4j.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "响应对象")
@Data
public class ResponseResult<T> {

	private static final int SUCCESS_CODE = 0;
	private static final String SUCCESS_MESSAGE = "成功";

	@ApiModelProperty(value = "响应码", name = "code", required = true)
	private int code;

	@ApiModelProperty(value = "响应消息", name = "msg", required = true)
	private String msg;

	@ApiModelProperty(value = "响应数据", name = "data")
	private T data;

}
