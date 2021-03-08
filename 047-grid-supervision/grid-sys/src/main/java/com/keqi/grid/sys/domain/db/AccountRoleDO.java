package com.keqi.grid.sys.domain.db;

import lombok.Data;


/**
 * 用户-角色表
 */
@Data
public class AccountRoleDO {

	/**
	 * 用户id
	 */
	private Long accountId;

	/**
	 * 角色id
	 */
	private Long roleId;

}