package com.keqi.knife4j.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictItemParam {

	@ApiModelProperty(value = "字典记录主键", example = "1", required = true)
	private Long id;

	@ApiModelProperty(value = "字典类型编码", example = "gender", required = true)
	private String typeCode;

	@ApiModelProperty(value = "字典类型名称", example = "性别", required = true)
	private String typeName;

	@ApiModelProperty(value = "字典项编码", example = "man", required = true)
	private String itemCode;

	@ApiModelProperty(value = "字典项值", example = "男", required = true)
	private String itemName;

	@ApiModelProperty(value = "字典项排序", example = "1", required = true)
	private Integer itemSort;

	@ApiModelProperty(value = "字典项备注字段")
	private String itemRemark;

	@ApiModelProperty(value = "字典项样式属性(备用字段)")
	private String itemCss;

}
