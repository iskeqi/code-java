package com.keqi.seed.sys.pojo;

/**
 * sys 模块常量类
 *
 * @author keqi
 */
public final class SysConstant {

	/**
	 * Redis 中存储用户的登录信息的 hash，key 为 uuid
	 */
	public static final String UUID_LOGIN_INFO = "loginInfo:uuid";

	/**
	 * Redis 中存储用户的登录信息的 hash，key 为 account
	 */
	public static final String ACCOUNT_LOGIN_INFO = "loginInfo:account";

	/**
	 * Redis 中存储被挤下线用户 token 的 set，元素中存储的是 token
	 */
	public static final String UUID_LOGOUT_INFO = "loginInfo:logout";
}
