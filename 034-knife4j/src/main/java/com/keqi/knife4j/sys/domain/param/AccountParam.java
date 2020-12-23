package com.keqi.knife4j.sys.domain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountParam {

    @ApiModelProperty(value = "用户名", example = "jack", required = true)
    private String account;

    @ApiModelProperty(value = "姓名", example = "杰克", required = true)
    private String nickName;

    @ApiModelProperty(value = "岗位", example = "java", required = true)
    private String post;

    @ApiModelProperty(value = "密码", example = "123456", required = true)
    private String password;
}