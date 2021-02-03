package com.keqi.seed.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UpdatePasswordParam {

	@ApiModelProperty(value = "原密码", example = "123456", required = true)
	private String password;

	@ApiModelProperty(value = "新密码", example = "981223", required = true)
	@Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间")
	private String newPassword;
}
