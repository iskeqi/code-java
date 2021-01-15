package com.keqi.knife4j.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统管理-字典表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictItemVO {

	@ApiModelProperty(value = "字典记录主键", example = "1")
	private Long id;

	@ApiModelProperty(value = "字典类型编码", example = "gender")
	private String typeCode;

	@ApiModelProperty(value = "字典类型名称", example = "性别")
	private String typeName;

	@ApiModelProperty(value = "字典项编码", example = "man")
	private String itemCode;

	@ApiModelProperty(value = "字典项值", example = "男")
	private String itemName;
}