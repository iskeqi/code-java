package com.keqi.seed.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictItemParam {

	@ApiModelProperty(value = "字典记录主键", example = "1", required = true)
	private Long id;

	@ApiModelProperty(value = "字典类型编码", example = "gender", required = true)
	private String typeCode;

	@ApiModelProperty(value = "字典类型名称", example = "性别", required = true)
	private String typeName;

	@ApiModelProperty(value = "字典编码", example = "man", required = true)
	private String itemCode;

	@ApiModelProperty(value = "字典值", example = "男", required = true)
	private String itemName;

	@ApiModelProperty(value = "排序字段", example = "1", required = true)
	private Integer orderNum;

}
