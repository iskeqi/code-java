package com.keqi.seed.sys.domain.db;

import com.keqi.seed.core.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 字典表
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DictItemDO2 extends BaseDO {

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