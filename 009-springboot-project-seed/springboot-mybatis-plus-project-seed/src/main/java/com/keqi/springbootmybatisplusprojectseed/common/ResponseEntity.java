package com.keqi.springbootmybatisplusprojectseed.common;

import lombok.Builder;
import lombok.Data;

/**
 * 响应实体类
 */
@Data
@Builder
public class ResponseEntity {

	private int status;

	private String msg;

	private Object body;

}
