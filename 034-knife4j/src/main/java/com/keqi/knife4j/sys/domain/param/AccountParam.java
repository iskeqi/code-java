package com.keqi.knife4j.sys.domain.param;

import com.keqi.knife4j.core.constraint.TypeCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountParam {

	@ApiModelProperty(value = "用户名", example = "jack", required = true)
	@Size(min = 2, max = 10, message = "用户名长度必须在2-10个字符之间")
	private String account;

	@ApiModelProperty(value = "姓名", example = "杰克", required = true)
	@Size(min = 2, max = 5, message = "姓名长度必须在2-5个字符之间")
	@NotNull
	private String nickName;

	@ApiModelProperty(value = "岗位", example = "java", required = true)
	@TypeCode("post")
	private String post;

	@ApiModelProperty(value = "密码", example = "123456", required = true)
	@Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间")
	private String password;
}