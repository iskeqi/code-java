package com.keqi.seed.sys.domain.param;

import com.keqi.seed.core.pojo.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DictItemPageParam extends PageParam {

	@ApiModelProperty(value = "字典类型编码")
	private String typeCode;

	@ApiModelProperty(value = "字典类型名称")
	private String typeName;

	@ApiModelProperty(value = "字典项编码")
	private String itemCode;

	@ApiModelProperty(value = "字典项值")
	private String itemName;
}
