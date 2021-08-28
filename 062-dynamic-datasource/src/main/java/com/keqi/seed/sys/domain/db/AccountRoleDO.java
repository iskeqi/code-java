package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户-角色关联表
 */
@Data
@TableName(value = "sys_account_role")
public class AccountRoleDO {
    /**
     * 用户id
     */
    @TableField(value = "account_id")
    private Long accountId;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    private Long roleId;
}