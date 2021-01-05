package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.knife4j.core.pojo.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 菜单表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu")
public class MenuDO extends BaseDO {

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