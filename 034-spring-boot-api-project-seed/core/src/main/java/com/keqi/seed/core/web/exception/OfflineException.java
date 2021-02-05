package com.keqi.seed.core.web.exception;

import java.io.Serializable;

/**
 * 已下线异常
 *
 * @author keqi
 */
public class OfflineException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 9206010918500095861L;

	public OfflineException(String message) {
		super(message);
	}
}
