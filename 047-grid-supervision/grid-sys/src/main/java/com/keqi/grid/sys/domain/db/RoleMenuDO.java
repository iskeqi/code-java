package com.keqi.grid.sys.domain.db;

import lombok.Data;


/**
 * 角色-权限表
 */
@Data
public class RoleMenuDO {

	/**
	 * 角色id
	 */
	private Long roleId;

	/**
	 * 菜单id
	 */
	private Long menuId;

}