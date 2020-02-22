package com.keqi.iotplatform.core.common;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应实体构建类
 *
 * @author keqi
 */
public class AjaxEntityBuilder {

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
	 * @return ajaxEntity
	 */
	public static AjaxEntity success(Object body) {
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
	public static AjaxPageEntity list(Long total, List<?> records) {
		AjaxPageEntity ajaxPageEntity = new AjaxPageEntity();
		ajaxPageEntity.setMsg(successMsg);
		ajaxPageEntity.setStatus(successCode);

		AjaxPageEntity.PageEntity obj = ajaxPageEntity.new PageEntity();
		obj.setTotal(total);
		obj.setRecords(records);
		ajaxPageEntity.setBody(obj);
		return ajaxPageEntity;
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

	/**
	 * 操作失败
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity failure(String msg) {
		return AjaxEntity.builder().msg(msg).status(failureCode)
				.build();
	}
}
