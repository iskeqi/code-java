package com.keqi.springbootswagger2.common;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应实体类
 *
 * @author keqi
 */
@Data
@Builder
public class AjaxEntity {

	private String status;
	private String msg;
	private Object body;

	private static final String successCode = "200";
	private static final String successMsg = "success";

	private static final String failureCode = "500";
	private static final String failureMsg = "failure";

	private static final String noAuthCode = "401";
	private static final String noAuthMsg = "no login or no permission";


	/**
	 * 单个对象
	 *
	 * @param body body
	 * @return ajaxEntity
	 */
	public static <T> AjaxEntity success(Object body) {
		return AjaxEntity.builder().status(successCode)
				.msg(successMsg)
				.body(body).build();
	}

	/**
	 * 没有返回值
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity success() {
		return AjaxEntity.builder().status(successCode)
				.msg(successMsg).build();
	}

	/**
	 * 只有一个返回值，但是又不想封装成对象来用
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity success(String key, Object value) {
		Map<String, Object> ret = new HashMap<>();
		ret.put(key, value);
		return AjaxEntity.builder().status(successCode)
				.msg(successMsg).body(ret).build();
	}

	/**
	 * 返回列表
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity list(long total, List<?> records) {
		Map<String, Object> retMap = new HashMap<>();
		retMap.put("total", total);
		retMap.put("records", records);
		return AjaxEntity.builder().status(successCode)
				.msg(successMsg)
				.body(retMap).build();
	}

	/**
	 * 未登录
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity noAuth() {
		return AjaxEntity.builder().status(noAuthCode)
				.msg(noAuthMsg).build();
	}

	/**
	 * 操作失败
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity failure() {
		return AjaxEntity.builder().msg(failureMsg).status(failureCode)
				.build();
	}
}
