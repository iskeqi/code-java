package com.keqi.foreststudy.forest.forestserverdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * forest-server-demo 响应实体类
 *
 * @author keqi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> {

	private Integer status;

	private String message;

	private T data;
}
