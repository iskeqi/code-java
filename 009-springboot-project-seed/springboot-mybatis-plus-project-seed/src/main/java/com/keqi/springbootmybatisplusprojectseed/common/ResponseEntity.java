package com.keqi.springbootmybatisplusprojectseed.common;

import lombok.Builder;
import lombok.Data;

/**
 * 响应实体类
 * @param <T> body泛型
 */
@Data
@Builder
public class ResponseEntity<T> {

	private int status;

	private String msg;

	private T body;

}
