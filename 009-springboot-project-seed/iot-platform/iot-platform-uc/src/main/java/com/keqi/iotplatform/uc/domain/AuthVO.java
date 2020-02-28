package com.keqi.iotplatform.uc.domain;

import lombok.Data;

/**
 * 用户登录VO
 */
@Data
public class AuthVO {

	 private String accessToken;

	 private Integer updatePasswordFlag;

	 private String uiTheme;

	 private Integer userType;
}
