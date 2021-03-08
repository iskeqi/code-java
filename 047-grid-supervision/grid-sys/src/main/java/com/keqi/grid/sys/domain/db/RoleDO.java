package com.keqi.grid.sys.domain.db;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 角色表
 */
@Data
public class RoleDO {

	/**
	 * 角色id
	 */
	private Long id;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 权限标识
	 */
	private String permiss;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

}