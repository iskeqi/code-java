package com.keqi.springbootknife4j.dev.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeGenUpdateParam {

	@ApiModelProperty(value = "主键", dataType = "Long", required = true,
			position = 1, example = "241")
	private Long id;

	@ApiModelProperty(value = "用户名", dataType = "String", required = true,
			position = 2, example = "grace")
	private String username;

	@ApiModelProperty(value = "年龄", dataType = "Integer", required = true,
			position = 3, example = "22")
	private Integer age;

	@ApiModelProperty(value = "体重", dataType = "Float", required = true,
			position = 4, example = "63.45")
	private Float weight;

}
