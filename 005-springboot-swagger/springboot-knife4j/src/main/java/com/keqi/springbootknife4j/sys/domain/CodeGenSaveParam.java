package com.keqi.springbootknife4j.sys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeGenSaveParam {

	@ApiModelProperty(value = "用户名", dataType = "String", required = true,
			position = 0, example = "grace")
	private String username;

	@ApiModelProperty(value = "年龄", dataType = "Integer", required = true,
			position = 1, example = "22")
	private Integer age;

	@ApiModelProperty(value = "体重", dataType = "Float", required = false,
			position = 2, example = "63.45")
	private Float weight;

}
