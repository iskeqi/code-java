package com.keqi.springbootmvctrain.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Student
 *
 * @author keqi
 */
@Data
public class Student {

	@ApiModelProperty(value = "姓名", example = "keqi")
	private String name;

	@ApiModelProperty(value = "年龄", example = "12", required = true)
	private Integer age;

	@ApiModelProperty(hidden = true)
	private String hidden;
}
