package com.keqi.seed.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统管理-字典表
 */
@Data
public class DictItemVO {

	@ApiModelProperty(value = "字典记录主键", example = "1")
	private Long id;

	@ApiModelProperty(value = "字典类型编码", example = "configType")
	private String typeCode;

	@ApiModelProperty(value = "字典类型名称", example = "参数配置类型")
	private String typeName;

	@ApiModelProperty(value = "字典项编码", example = "configType:xtnz")
	private String itemCode;

	@ApiModelProperty(value = "字典项值", example = "系统内置")
	private String itemName;
}