package com.keqi.seed.core.exception;

/**
 * 业务异常类（当校验用户输入不合法时，通过抛出此异常给用户界面作为提示信息）
 *
 * @author keqi
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 3079094397328685938L;

	/**
	 * 创建异常对象(必须指定异常信息，故在此处屏蔽了空的构造函数)
	 *
	 * @param message 异常信息
	 */
	public BusinessException(String message) {
		super(message);
	}
}
