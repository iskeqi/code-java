package com.keqi.seed.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;

public class LoginVO {

	@ApiModelProperty(value = "登录返回token", example = "eyJhbJ9.eyJpXhwIjE4NDAwfQ.7B7yP9bqhMjQ")
	private String accessToken;

	public LoginVO() {
	}

	public LoginVO(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
