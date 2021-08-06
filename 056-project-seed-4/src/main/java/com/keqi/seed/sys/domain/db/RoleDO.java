package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.seed.core.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_role")
public class RoleDO extends BaseDO {
    /**
     * 角色名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 权限标识
     */
    @TableField(value = "permiss")
    private String permiss;
}