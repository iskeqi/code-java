package com.qjzh.idomp.zjc.core.common;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应实体构建类
 *
 * @author keqi
 */
public class AjaxEntityBuilder {

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
     * @return ajaxEntity
     */
    public static AjaxEntity success(Object body) {
        AjaxEntity ajaxEntity = new AjaxEntity();
        ajaxEntity.setStatus(successCode);
        ajaxEntity.setMsg(successMsg);
        ajaxEntity.setBody(body);
        return ajaxEntity;
    }

    /**
     * 单个数组对象
     *
     * @param list list
     * @return ajaxEntity
     */
    public static AjaxEntity successList(List<?> list) {
        AjaxEntity ajaxEntity = new AjaxEntity();
        ajaxEntity.setStatus(successCode);
        ajaxEntity.setMsg(successMsg);
        ajaxEntity.setBody(list == null ? new ArrayList() : list);
        return ajaxEntity;
    }

    /**
     * 没有返回值
     *
     * @return ajaxEntity
     */
    public static AjaxEntity success() {
        AjaxEntity ajaxEntity = new AjaxEntity();
        ajaxEntity.setStatus(successCode);
        ajaxEntity.setMsg(successMsg);
        return ajaxEntity;
    }

    /**
     * 只有一个返回值，但是又不想封装成对象来用
     *
     * @return ajaxEntity
     */
    public static AjaxEntity success(String key, Object value) {
        Map<String, Object> ret = new HashMap<>();
        ret.put(key, value);

        AjaxEntity ajaxEntity = new AjaxEntity();
        ajaxEntity.setStatus(successCode);
        ajaxEntity.setMsg(successMsg);
        ajaxEntity.setBody(ret);
        return ajaxEntity;
    }

    /**
     * 返回列表
     *
     * @return ajaxEntity
     */
    public static AjaxPageEntity list(Long total, List<Object> list) {
        AjaxPageEntity ajaxPageEntity = new AjaxPageEntity();
        ajaxPageEntity.setMsg(successMsg);
        ajaxPageEntity.setStatus(successCode);

        AjaxPageEntity.PageEntity obj = new AjaxPageEntity.PageEntity();
        obj.setTotal(total);
        obj.setList(list);
        ajaxPageEntity.setBody(obj);
        return ajaxPageEntity;
    }

    /**
     * 未登录
     *
     * @return ajaxEntity
     */
    public static AjaxEntity noAuth() {
        AjaxEntity ajaxEntity = new AjaxEntity();
        ajaxEntity.setStatus(noAuthCode);
        ajaxEntity.setMsg(noAuthMsg);
        return ajaxEntity;
    }

    /**
     * 操作失败
     *
     * @return ajaxEntity
     */
    public static AjaxEntity failure() {
        AjaxEntity ajaxEntity = new AjaxEntity();
        ajaxEntity.setStatus(failureCode);
        ajaxEntity.setMsg(failureMsg);
        return ajaxEntity;
    }

    /**
     * 操作失败
     *
     * @return ajaxEntity
     */
    public static AjaxEntity failure(String msg) {
        AjaxEntity ajaxEntity = new AjaxEntity();
        ajaxEntity.setStatus(failureCode);
        ajaxEntity.setMsg(msg);
        return ajaxEntity;
    }
}
