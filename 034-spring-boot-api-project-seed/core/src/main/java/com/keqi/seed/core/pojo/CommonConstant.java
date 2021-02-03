package com.keqi.seed.core.pojo;

/**
 * 系统公共常量类
 *
 * @author keqi
 */
public final class CommonConstant {

	/**
	 * 存储登录用户信息 Map 对应的 key
	 */
	public static final String LOGIN_USER = "loginUser";

	/**
	 * token 名称
	 */
	public static final String TOKEN = "token";

	/**
	 * 项目根包名
	 */
	public static final String ROOT_PACKAGE_NAME = "com.keqi.seed";

	/**
	 * 私有文件上传根路径
	 */
	public static final String UPLOAD_FILE_PRIVATE_FILE = "/uploadFile/privateFile/";

	/**
	 * 公开文件上传根路径
	 */
	public static final String UPLOAD_FILE_PUBLIC_FILE = "/uploadFile/publicFile/";

	/**
	 * Redis 中存储用户的登录信息的 hash，key 为 uuid
	 */
	public static final String UUID_LOGIN_INFO = "loginInfo:uuid";

	/**
	 * Redis 中存储用户的登录信息的 hash，key 为 accountId
	 */
	public static final String ACCOUNT_ID_LOGIN_INFO = "loginInfo:accountId";
}
