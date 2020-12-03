package com.keqi.bestpracticeone.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    @ApiModelProperty(value = "登录返回token", example = "eyJhbJ9.eyJpXhwIjE4NDAwfQ.7B7yP9bqhMjQ")
    private String accessToken;
}
