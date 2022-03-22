package com.keqi.seed.core.exception;

/**
 * 参数不合法时，抛出此异常
 *
 * @author keqi
 */
public class ParamException extends RuntimeException {

	private static final long serialVersionUID = -2822572866118758315L;

	public ParamException(String message) {
		super(message);
	}
}
