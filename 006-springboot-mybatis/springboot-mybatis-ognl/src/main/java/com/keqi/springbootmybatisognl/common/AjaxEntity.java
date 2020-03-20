package com.keqi.springbootmybatisognl.common;

/**
 * 响应实体类
 *
 * @author keqi
 */
public class AjaxEntity {

	private Integer status;

	private String msg;

	private Object body;

	public AjaxEntity() {
	}

	public AjaxEntity(Integer status, String msg, Object body) {
		this.status = status;
		this.msg = msg;
		this.body = body;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
}
