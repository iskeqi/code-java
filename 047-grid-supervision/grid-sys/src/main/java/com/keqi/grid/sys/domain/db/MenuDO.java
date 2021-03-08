package com.keqi.grid.sys.domain.db;

import lombok.Data;


/**
 * 权限表
 */
@Data
public class MenuDO {

	/**
	 * 菜单id
	 */
	private Long id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 请求URL地址
	 */
	private String url;

	/**
	 * ICON图标
	 */
	private String icon;

	/**
	 * 菜单类型（C目录 M菜单 B按钮）
	 */
	private String type;

	/**
	 * 权限标识
	 */
	private String permiss;

	/**
	 * 父级ID
	 */
	private Long parentId;

	/**
	 * 排序字段
	 */
	private Integer orderNum;

}