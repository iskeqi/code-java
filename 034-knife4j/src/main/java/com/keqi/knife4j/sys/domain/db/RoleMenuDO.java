package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 角色-菜单表
 */
@Data
@TableName(value = "sys_role_menu")
public class RoleMenuDO {

	/**
	 * 角色ID
	 */
	@TableField(value = "role_id")
	private Long roleId;

	/**
	 * 菜单ID
	 */
	@TableField(value = "menu_id")
	private Long menuId;
}