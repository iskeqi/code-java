package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 菜单表
 */
@Data
@TableName(value = "sys_menu")
public class MenuDO {

	/**
	 * 菜单id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 名称
	 */
	@TableField(value = "name")
	private String name;

	/**
	 * 请求URL地址
	 */
	@TableField(value = "url")
	private String url;

	/**
	 * ICON图标
	 */
	@TableField(value = "icon")
	private String icon;

	/**
	 * 菜单类型（C目录 M菜单 B按钮）
	 */
	@TableField(value = "type")
	private String type;

	/**
	 * 权限标识
	 */
	@TableField(value = "permiss")
	private String permiss;

	/**
	 * 排序字段
	 */
	@TableField(value = "order_num")
	private Integer orderNum;

	/**
	 * 父级ID
	 */
	@TableField(value = "parent_id")
	private Long parentId;
}