package com.keqi.iotplatform.core.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页响应实体类
 *
 * @author keqi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxPageEntity<T> {

	private Integer status;

	private String msg;

	private PageEntity<T> body;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class PageEntity<T> {

		private Long total;

		private List<T> records;
	}
}
