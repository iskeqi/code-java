package com.keqi.seed.core.exception;

/**
 * 已下线异常
 *
 * @author keqi
 */
public class OfflineException extends RuntimeException {

	private static final long serialVersionUID = -7409977126967080045L;

	public OfflineException(String message) {
		super(message);
	}
}
