package com.keqi.knife4j.core.exception;

import java.io.Serializable;

/**
 * 未登录异常类
 *
 * @author keqi
 */
public class NoAuthException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -3046894916822410577L;

	/**
	 * 创建异常对象
	 */
	public NoAuthException() {
		super();
	}
}
