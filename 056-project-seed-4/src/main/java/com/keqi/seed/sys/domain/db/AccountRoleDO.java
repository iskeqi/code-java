package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户-角色关联表
 */
@Data
@Accessors(chain = true)
@TableName(value = "sys_account_role")
public class AccountRoleDO {

    @ApiModelProperty("用户id")
    private String accountId;

    @ApiModelProperty("角色id")
    private String roleId;
}