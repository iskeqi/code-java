package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色-菜单关联表
 */
@Data
@TableName(value = "sys_role_menu")
public class RoleMenuDO {
    /**
     * 角色id
     */
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private Long roleId;

    /**
     * 菜单id
     */
    @TableId(value = "menu_id", type = IdType.ASSIGN_ID)
    private Long menuId;
}