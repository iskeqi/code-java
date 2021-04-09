package com.keqi.seed.core.exception;

/**
 * SpringValidatorException
 *
 * @author keqi
 */
public class ValidatorException extends RuntimeException {

	private static final long serialVersionUID = -2822572866118758315L;

	public ValidatorException(String message) {
		super(message);
	}
}
