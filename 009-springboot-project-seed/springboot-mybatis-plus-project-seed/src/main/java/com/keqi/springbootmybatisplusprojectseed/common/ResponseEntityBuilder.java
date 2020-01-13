package com.keqi.springbootmybatisplusprojectseed.common;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ResponseEntity构建类
 */
public class ResponseEntityBuilder {

	private static final int successCode = HttpStatus.OK.value();
	private static final String successMsg = HttpStatus.OK.getReasonPhrase();

	private static final int failureCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
	private static final String failureMsg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

	private static final int noAuthCode = HttpStatus.UNAUTHORIZED.value();
	private static final String noAuthMsg = HttpStatus.UNAUTHORIZED.getReasonPhrase();

	/**
	 * 单个对象
	 *
	 * @param body body
	 * @return ResponseEntity
	 */
	public static <T> ResponseEntity success(Object body) {
		return ResponseEntity.builder().status(successCode)
				.msg(successMsg)
				.body(body).build();
	}

	/**
	 * 没有返回值
	 *
	 * @return ResponseEntity
	 */
	public static ResponseEntity success() {
		return ResponseEntity.builder().status(successCode)
				.msg(successMsg).build();
	}

	/**
	 * 只有一个返回值，但是又不想封装成对象来用
	 *
	 * @return ResponseEntity
	 */
	public static ResponseEntity success(String key, Object value) {
		Map<String, Object> ret = new HashMap<>();
		ret.put(key, value);
		return ResponseEntity.builder().status(successCode)
				.msg(successMsg).body(ret).build();
	}

	/**
	 * 返回列表
	 *
	 * @return ResponseEntity
	 */
	public static ResponseEntity list(long total, List<?> records) {
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("total", total);
		retMap.put("records", records);
		return ResponseEntity.builder().status(successCode)
				.msg(successMsg)
				.body(retMap).build();
	}

	/**
	 * 未登录
	 *
	 * @return ResponseEntity
	 */
	public static ResponseEntity noAuth() {
		return ResponseEntity.builder().status(noAuthCode)
				.msg(noAuthMsg).build();
	}

	/**
	 * 操作失败
	 *
	 * @return ResponseEntity
	 */
	public static ResponseEntity failure() {
		return ResponseEntity.builder().msg(failureMsg).status(failureCode)
				.build();
	}

}
