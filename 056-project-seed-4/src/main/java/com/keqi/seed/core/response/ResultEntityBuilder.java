package com.keqi.seed.core.response;

import com.keqi.seed.core.exception.BusinessException;

/**
 * 响应实体构建类
 *
 * @author keqi
 */
public class ResultEntityBuilder {

    /**
     * 单个对象
     *
     * @param body body
     * @return r 如果是一个空的List对象，那么 body 的值会是 []
     */
    public static ResultEntity success(Object body) {
        return new ResultEntity(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getCodeName(), body);
    }

    /**
     * 没有返回值
     *
     * @return r
     */
    public static ResultEntity success() {
        return new ResultEntity(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getCodeName(), null);
    }

    /**
     * 未登录
     *
     * @return r
     */
    public static ResultEntity noAuth(String message) {
        return new ResultEntity(ResultStatusEnum.NO_AUTH.getCode(), message, null);
    }

    /**
     * 操作失败
     *
     * @param msg msg
     * @return r
     */
    public static ResultEntity failure(String msg) {
        return new ResultEntity(ResultStatusEnum.FAILURE.getCode(), msg, null);
    }

    /**
     * 异常返回
     *
     * @param e e
     * @return r
     */
    public static ResultEntity business(BusinessException e) {
        return new ResultEntity(e.getStatus(), e.getMessage(), null);
    }

    /**
     * 参数错误
     *
     * @param message message
     * @return r
     */
    public static ResultEntity paramIllegal(String message) {
        return new ResultEntity(ResultStatusEnum.PARAM_ILLEGAL.getCode(), message, null);
    }
}
