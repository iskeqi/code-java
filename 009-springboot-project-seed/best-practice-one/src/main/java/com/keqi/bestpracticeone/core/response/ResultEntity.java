package com.keqi.bestpracticeone.core.response;

/**
 * 响应实体类
 *
 * @author keqi
 */
public class ResultEntity {

    private Integer code;

    private String message;

    private Object data;

    public ResultEntity() {
    }

    public ResultEntity(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
