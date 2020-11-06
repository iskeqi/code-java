package com.keqi.springbootknife4j.sys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeGenPageParam {

	@ApiModelProperty(value = "用户名", example = "grace")
	private String username;

	@ApiModelProperty(value = "年龄", example = "22")
	private Integer age;

	@ApiModelProperty(value = "体重", example = "63.45")
	private Float weight;

	@ApiModelProperty(value = "当前页数", required = true, example = "1")
	private Long current;

	@ApiModelProperty(value = "每页大小", required = true, example = "20")
	private Long size;
}
