package com.keqi.bestpracticeone.core.response;

import org.springframework.http.HttpStatus;

/**
 * 响应实体构建类
 *
 * @author keqi
 */
public class ResultEntityBuilder {

    /*OK(200, "OK")*/
    private static final int successCode = HttpStatus.OK.value();
    private static final String successMsg = HttpStatus.OK.getReasonPhrase();

    /*INTERNAL_SERVER_ERROR(500, "Internal Server Error")*/
    private static final int failureCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    private static final String failureMsg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

    /*UNAUTHORIZED(401, "Unauthorized")*/
    private static final int noAuthCode = HttpStatus.UNAUTHORIZED.value();
    private static final String noAuthMsg = HttpStatus.UNAUTHORIZED.getReasonPhrase();

    /**
     * 单个对象
     *
     * @param body body
     * @return r 如果是一个空的List对象，那么 body 的值会是 []
     */
    public static ResultEntity success(Object body) {
        return new ResultEntity(successCode, successMsg, body);
    }

    /**
     * 没有返回值
     *
     * @return r
     */
    public static ResultEntity success() {
        return new ResultEntity(successCode, successMsg, null);
    }

    /**
     * 未登录
     *
     * @return r
     */
    public static ResultEntity noAuth() {
        return new ResultEntity(noAuthCode, noAuthMsg, null);
    }

    /**
     * 操作失败
     *
     * @return r
     */
    public static ResultEntity failure() {
        return new ResultEntity(failureCode, failureMsg, null);
    }

    /**
     * 操作失败
     *
     * @param msg msg
     * @return r
     */
    public static ResultEntity failure(String msg) {
        return new ResultEntity(failureCode, msg, null);
    }

    /**
     * 操作失败
     *
     * @param throwable throwable
     * @return r
     */
    public static ResultEntity failure(Throwable throwable) {
        return new ResultEntity(failureCode, failureMsg, throwable);
    }
}
