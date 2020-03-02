package com.qjzh.idomp.zjc.core.common;

import java.util.List;

/**
 * 响应实体类（带分页）
 *
 * @author keqi
 */
public class AjaxPageEntity {

    public AjaxPageEntity() {
    }

    public AjaxPageEntity(Integer status, String msg, PageEntity body) {
        this.status = status;
        this.msg = msg;
        this.body = body;
    }

    private Integer status;

    private String msg;

    private PageEntity body;

    public static class PageEntity {

        public PageEntity() {
        }

        public PageEntity(Long total, List<Object> list) {
            this.total = total;
            this.list = list;
        }

        private Long total;

        private List<Object> list;

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public List<Object> getList() {
            return list;
        }

        public void setList(List<Object> list) {
            this.list = list;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PageEntity getBody() {
        return body;
    }

    public void setBody(PageEntity body) {
        this.body = body;
    }
}
