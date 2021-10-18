package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户-角色关联表
 */
@Data
@TableName(value = "sys_account_role")
public class AccountRoleDO {

    @ApiModelProperty("用户id")
    private Long accountId;

    @ApiModelProperty("角色id")
    private Long roleId;
}