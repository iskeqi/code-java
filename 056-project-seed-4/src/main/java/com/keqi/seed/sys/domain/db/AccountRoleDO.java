package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "account_id", type = IdType.ASSIGN_ID)
    private Long accountId;

    /**
     * 角色id
     */
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private Long roleId;
}