package com.keqi.springbootknife4j.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 响应实体类
 *
 * @author keqi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxPageEntity<T> {

	@ApiModelProperty(value = "状态码", dataType = "String", required = true,
			position = 1, example = "200")
	private Integer status;

	@ApiModelProperty(value = "说明", dataType = "String", required = true,
			position = 2, example = "OK")
	private String msg;

	@ApiModelProperty(value = "响应体", dataType = "String", required = true,
			position = 3)
	private PageEntity<T> body;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class PageEntity<T> {

		@ApiModelProperty(value = "总记录数", dataType = "Integer", required = true,
				position = 1, example = "200")
		private Long total;

		@ApiModelProperty(value = "记录列表", dataType = "List", required = true,
				position = 2)
		private List<T> records;
	}
}
