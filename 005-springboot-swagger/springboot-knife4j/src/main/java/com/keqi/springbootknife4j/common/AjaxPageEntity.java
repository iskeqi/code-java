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

	@ApiModelProperty(value = "状态码", required = true, example = "200")
	private Integer status;

	@ApiModelProperty(value = "说明", required = true, example = "OK")
	private String msg;

	@ApiModelProperty(value = "响应体", required = true)
	private PageEntity body;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class PageEntity {

		@ApiModelProperty(value = "总记录数", required = true, example = "200")
		private Long total;

		@ApiModelProperty(value = "记录列表", required = true)
		private List<T> records;
	}
}
