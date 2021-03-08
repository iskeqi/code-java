package com.keqi.grid.sys.domain.db;

import lombok.Data;


/**
 * 字典表
 */
@Data
public class DictItemDO {

	/**
	 * 字典项id
	 */
	private Long id;

	/**
	 * 字典类型编码
	 */
	private String typeCode;

	/**
	 * 字典类型名称
	 */
	private String typeName;

	/**
	 * 字典项编码
	 */
	private String itemCode;

	/**
	 * 字典项值
	 */
	private String itemName;

	/**
	 * 排序字段
	 */
	private Integer orderNum;

}