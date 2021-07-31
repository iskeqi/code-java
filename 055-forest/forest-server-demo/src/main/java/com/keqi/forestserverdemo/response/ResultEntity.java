package com.keqi.forestserverdemo.response;

/**
 * 响应实体类
 *
 * @author keqi
 */
public class ResultEntity {

	private Integer status;

	private String message;

	private Object data;

	public ResultEntity() {
	}

	public ResultEntity(Integer status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
