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

	@ApiModelProperty(value = "状态码", dataType = "String", required = true,
			position = 1, example = "200")
	private Integer status;

	@ApiModelProperty(value = "说明", dataType = "String", required = true,
			position = 2, example = "OK")
	private String msg;

	@ApiModelProperty(value = "响应体", dataType = "String", required = true,
			position = 3)
	private T body;
}
