package com.keqi.springbootmybatisbase.sys.domain.db;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 菜单表
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
	 * 菜单类型 [C 目录，M 菜单，B 按钮]
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

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

}