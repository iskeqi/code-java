package com.keqi.bestpracticeone.sys.domain.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
    * 用户表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_account")
public class AccountDO {
    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "account")
    private String account;

    /**
     * 姓名
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 岗位
     */
    @TableField(value = "post")
    private String post;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}