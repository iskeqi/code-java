package com.keqi.seed.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AuthParam {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("当前登录设备")
    private String device;
}
