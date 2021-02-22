package com.keqi.seed.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;

public class LoginVO {

	@ApiModelProperty(value = "登录返回token", example = "eyJhbJ9.eyJpXhwIjE4NDAwfQ.7B7yP9bqhMjQ")
	private String token;

	public LoginVO() {
	}

	public LoginVO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void settoken(String token) {
		this.token = token;
	}
}
