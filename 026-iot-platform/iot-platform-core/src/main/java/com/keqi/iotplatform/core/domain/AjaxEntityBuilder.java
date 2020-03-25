package com.keqi.iotplatform.core.domain;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 响应实体构建类
 *
 * @author keqi
 */
public class AjaxEntityBuilder {

	/*OK(200, "OK")*/
	private static final int successCode = HttpStatus.OK.value();
	private static final String successMsg = HttpStatus.OK.getReasonPhrase();

	/*INTERNAL_SERVER_ERROR(500, "Internal Server Error")*/
	private static final int failureCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
	private static final String failureMsg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

	/*UNAUTHORIZED(401, "Unauthorized")*/
	private static final int noAuthCode = HttpStatus.UNAUTHORIZED.value();
	private static final String noAuthMsg = HttpStatus.UNAUTHORIZED.getReasonPhrase();


	/**
	 * 单个对象
	 *
	 * @param body body
	 * @return ajaxEntity {}
	 */
	public static AjaxEntity success(Object body) {
		AjaxEntity ajaxEntity = new AjaxEntity();
		ajaxEntity.setStatus(successCode);
		ajaxEntity.setMsg(successMsg);
		ajaxEntity.setBody(body == null ? new Object() : body);
		return ajaxEntity;
	}

	/**
	 * 单个数组对象
	 *
	 * @param list list
	 * @return ajaxEntity
	 */
	public static AjaxEntity success(List<?> list) {
		AjaxEntity ajaxEntity = new AjaxEntity();
		ajaxEntity.setStatus(successCode);
		ajaxEntity.setMsg(successMsg);
		ajaxEntity.setBody(list == null ? new ArrayList() : list);
		return ajaxEntity;
	}

	/**
	 * 没有返回值
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity success() {
		AjaxEntity ajaxEntity = new AjaxEntity();
		ajaxEntity.setStatus(successCode);
		ajaxEntity.setMsg(successMsg);
		return ajaxEntity;
	}


	/**
	 * 返回列表
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity successList(long total, List<Object> list) {
		AjaxEntity ajaxEntity = new AjaxEntity();
		ajaxEntity.setMsg(successMsg);
		ajaxEntity.setStatus(successCode);

		PageVO pageVO = new PageVO();
		pageVO.setTotal(total);
		pageVO.setList(list == null ? Collections.emptyList() : list);
		ajaxEntity.setBody(pageVO);

		return ajaxEntity;
	}

	/**
	 * 返回列表
	 *
	 * @param pageVO pageVO
	 * @return r
	 */
	public static AjaxEntity successList(PageVO pageVO) {
		AjaxEntity ajaxEntity = new AjaxEntity();
		ajaxEntity.setMsg(successMsg);
		ajaxEntity.setStatus(successCode);

		List<?> list = pageVO.getList();
		pageVO.setList(list == null ? Collections.emptyList() : list);
		ajaxEntity.setBody(pageVO);

		return ajaxEntity;
	}

	/**
	 * 未登录
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity noAuth() {
		AjaxEntity ajaxEntity = new AjaxEntity();
		ajaxEntity.setStatus(noAuthCode);
		ajaxEntity.setMsg(noAuthMsg);
		return ajaxEntity;
	}

	/**
	 * 操作失败
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity failure() {
		AjaxEntity ajaxEntity = new AjaxEntity();
		ajaxEntity.setStatus(failureCode);
		ajaxEntity.setMsg(failureMsg);
		return ajaxEntity;
	}

	/**
	 * 操作失败
	 *
	 * @return ajaxEntity
	 */
	public static AjaxEntity failure(String msg) {
		AjaxEntity ajaxEntity = new AjaxEntity();
		ajaxEntity.setStatus(failureCode);
		ajaxEntity.setMsg(msg);
		return ajaxEntity;
	}
}
