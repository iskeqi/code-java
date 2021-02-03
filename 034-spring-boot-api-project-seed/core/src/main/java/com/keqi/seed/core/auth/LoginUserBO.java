package com.keqi.seed.core.auth;

import lombok.Data;

/**
 * 登录用户信息实体类
 *
 * @author keqi
 */
@Data
public class LoginUserBO {

	/**
	 * 用户id
	 */
	private Long id;

	/**
	 * 登录用户账号名
	 */
	private String account;

	/**
	 * token 到期时间
	 */
	private Long expirationTime;

	/**
	 * token
	 */
	private String token;
}
