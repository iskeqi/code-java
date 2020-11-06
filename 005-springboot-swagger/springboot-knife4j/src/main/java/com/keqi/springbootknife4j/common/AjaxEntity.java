package com.keqi.springbootknife4j.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应实体类
 *
 * @author keqi
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AjaxEntity<T> {

	@ApiModelProperty(value = "状态码", required = true, example = "200")
	private Integer status;

	@ApiModelProperty(value = "说明", required = true, example = "OK")
	private String msg;

	@ApiModelProperty(value = "响应体", required = true)
	private T body;
}
