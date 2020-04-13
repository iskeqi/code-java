package com.keqi.apihu.manage.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.apihu.core.common.BaseDO;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper=true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "sys_account")
public class AccountDO extends BaseDO {
    /**
     * 用户账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 用户名称
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
    @TableField(value = "password")
    private String password;
}