package com.keqi.springbootmybatismapperxml.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysNoticeObj {
    /**
    * 公告ID
    */
    private Object noticeId;

    /**
    * 公告标题
    */
    private Object noticeTitle;

    /**
    * 公告类型（1通知 2公告）
    */
    private Object noticeType;

    /**
    * 公告内容
    */
    private Object noticeContent;

    /**
    * 公告状态（0正常 1关闭）
    */
    private Object status;

    /**
    * 创建者
    */
    private Object createBy;

    /**
    * 创建时间
    */
    private Object createTime;

    /**
    * 更新者
    */
    private Object updateBy;

    /**
    * 更新时间
    */
    private Object updateTime;

    /**
    * 备注
    */
    private Object remark;
}