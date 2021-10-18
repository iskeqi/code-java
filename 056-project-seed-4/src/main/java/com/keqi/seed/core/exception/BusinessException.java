package com.keqi.seed.core.exception;

import com.keqi.seed.core.response.ResultStatusEnum;

/**
 * 业务异常类
 *
 * @author keqi
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 3079094397328685938L;

    private final String status;

    public String getStatus() {
        return status;
    }

    /**
     * 创建异常对象(必须指定异常信息，故在此处屏蔽了空的构造函数)(默认为参数错误类型)
     *
     * @param message 异常信息
     */
    public BusinessException(String message) {
        super(message);
        status = ResultStatusEnum.PARAM_ILLEGAL.getCode();
    }

    /**
     * 指定异常错误码的抛出异常方式
     *
     * @param statusEnum statusEnum
     */
    public BusinessException(ResultStatusEnum statusEnum) {
        super(statusEnum.getCodeName());
        status = statusEnum.getCode();
    }

    /**
     * 指定异常错误码和展示内容的抛出异常方式
     *
     * @param statusEnum statusEnum
     * @param message    message
     */
    public BusinessException(ResultStatusEnum statusEnum, String message) {
        super(message);
        status = statusEnum.getCode();
    }
}
