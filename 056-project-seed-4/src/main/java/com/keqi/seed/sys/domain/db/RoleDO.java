package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.seed.core.pojo.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role")
public class RoleDO extends BaseDO {

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("权限标识")
    private String permiss;
}