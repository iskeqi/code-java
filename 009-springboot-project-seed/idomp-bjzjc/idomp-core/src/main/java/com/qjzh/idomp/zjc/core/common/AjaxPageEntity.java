package com.qjzh.idomp.zjc.core.common;

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
public class AjaxPageEntity {

	private Integer status;

	private String msg;

	private PageEntity body;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class PageEntity {

		private Long total;

		private List<Object> list;
	}
}
