package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.knife4j.core.pojo.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 系统管理-字典表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_dict_item")
public class DictItemDO extends BaseDO {

	/**
	 * 字典类型编码
	 */
	@TableField(value = "type_code")
	private String typeCode;

	/**
	 * 字典类型名称
	 */
	@TableField(value = "type_name")
	private String typeName;

	/**
	 * 字典项编码
	 */
	@TableField(value = "item_code")
	private String itemCode;

	/**
	 * 字典项值
	 */
	@TableField(value = "item_name")
	private String itemName;

	/**
	 * 字典项排序
	 */
	@TableField(value = "item_sort")
	private Integer itemSort;

	/**
	 * 字典项备注字段
	 */
	@TableField(value = "item_remark")
	private String itemRemark;

	/**
	 * 字典项样式属性(备用字段)
	 */
	@TableField(value = "item_css")
	private String itemCss;

	/**
	 * 逻辑删除字段（0 未删除，1 已删除）
	 */
	@TableField(value = "is_deleted")
	private Integer deleted;
}