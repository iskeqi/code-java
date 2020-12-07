package com.keqi.springbootknife4j.sys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeGenSaveParam {

	@ApiModelProperty(value = "用户名",  required = true, example = "grace")
	private String username;

	@ApiModelProperty(value = "年龄",  required = true, example = "22")
	private Integer age;

	@ApiModelProperty(value = "体重",  required = false, example = "63.45")
	private Float weight;

}
