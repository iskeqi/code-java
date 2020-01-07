package com.keqi.springbootknife4j.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@ApiModel(description = "用户Model")
public class User {

	@Null(message = "id必须为空")
	@ApiModelProperty(value = "用户ID", name = "id")
	private Integer id;

	@NotBlank(message = "用户名不能为空")
	@ApiModelProperty(value = "用户名", name = "username", required = true, example = "zhaoliu")
	private String username;

	@NotBlank(message = "密码不能为空")
	@ApiModelProperty(value = "密码", name = "password", required = true, example = "123456")
	private String password;
}
