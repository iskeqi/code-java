package com.keqi.hcttopgenerate.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 字典表
 */
@Data
public class DictItem {

	/**
	 * 字典项id
	 */
	@ApiModelProperty(value = "id", example = "1", required = true)
	private Long id;

	/**
	 * 字典类型编码
	 */
	@ApiModelProperty(value = "id", example = "1", required = true)
	private String typeCode;

	/**
	 * 字典类型名称
	 */
	@ApiModelProperty(value = "id", example = "1", required = true)
	private String typeName;

	/**
	 * 字典项编码
	 */
	@ApiModelProperty(value = "id", example = "1", required = true)
	private String itemCode;

	/**
	 * 字典项值
	 */
	@ApiModelProperty(value = "id", example = "1", required = true)
	private String itemName;

	/**
	 * 排序字段
	 */
	@ApiModelProperty(value = "id", example = "1", required = true)
	private Integer orderNum;

}