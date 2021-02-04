package com.keqi.seed.sys.pojo;

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

	/**
	 * 登录设备类型
	 */
	private String devType;
}
