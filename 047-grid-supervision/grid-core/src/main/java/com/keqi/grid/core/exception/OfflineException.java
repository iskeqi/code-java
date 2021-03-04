package com.keqi.grid.core.exception;

import java.io.Serializable;

/**
 * 已下线异常
 *
 * @author keqi
 */
public class OfflineException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -519702084925188237L;

	public OfflineException(String message) {
		super(message);
	}
}
