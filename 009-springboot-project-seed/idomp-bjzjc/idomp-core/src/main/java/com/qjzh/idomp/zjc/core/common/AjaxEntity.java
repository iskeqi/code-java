package com.qjzh.idomp.zjc.core.common;

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
public class AjaxEntity {

	private Integer status;

	private String msg;

	private Object body;
}
