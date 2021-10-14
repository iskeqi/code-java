package com.keqi.seed.core.response;

/**
 * 响应实体类
 *
 * @author keqi
 */
public class ResultEntity<T> {

	private String status;

	private String message;

	private T data;

	public ResultEntity() {
	}

	public ResultEntity(String status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
