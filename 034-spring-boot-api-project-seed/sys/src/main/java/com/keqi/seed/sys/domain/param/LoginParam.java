package com.keqi.seed.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class LoginParam {

    @ApiModelProperty(value = "账号", example = "admin", required = true)
    @NotNull(message = "账号为必填项")
    @Size(min = 2, max = 10, message = "用户名长度必须在2-10个字符之间")
    private String account;

    @ApiModelProperty(value = "密码", example = "123456", required = true)
    @NotNull(message = "密码为必填项")
    @Size(min = 6, max = 20, message = "密码长度必须在6-20个字符之间")
    private String password;

    @ApiModelProperty(value = "登录设备类型[浏览器 web, 手机 mobile]", example = "web", required = true)
    @NotNull(message = "登录设备类型为必填项")
    @Pattern(regexp = "web|mobile", message = "登录设备类型只能是 web 或者 mobile")
    private String devType;
}
