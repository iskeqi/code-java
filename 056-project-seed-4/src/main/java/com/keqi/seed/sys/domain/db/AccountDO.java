package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.seed.core.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户表
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_account")
public class AccountDO extends BaseDO {
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
     * 盐
     */
    @TableField(value = "salt")
    private String salt;
}