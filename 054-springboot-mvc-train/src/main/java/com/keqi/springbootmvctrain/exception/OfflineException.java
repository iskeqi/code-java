package com.keqi.springbootmvctrain.exception;

/**
 * 已下线异常
 *
 * @author keqi
 */
public class OfflineException extends RuntimeException {

	private static final long serialVersionUID = 9206010918500095861L;

	public OfflineException(String message) {
		super(message);
	}
}
