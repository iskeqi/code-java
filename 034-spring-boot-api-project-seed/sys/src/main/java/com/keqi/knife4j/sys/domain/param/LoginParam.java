package com.keqi.knife4j.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
public class LoginParam {

	@ApiModelProperty(name = "account", value = "账号", example = "admin", required = true)
	@Size(min = 2, max = 10, message = "用户名长度必须在2-10个字符之间")
	private String account;

	@ApiModelProperty(name = "password", value = "密码", example = "123456", required = true)
	@Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间")
	private String password;
}
