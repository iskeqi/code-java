package com.keqi.iotplatform.core.domain;

/**
 * 登录用户信息实体类
 *
 * @author keqi
 */
public class LoginUserBO {

	/**
	 * 登录用户账号名
	 */
	private String loginAccount;

	/**
	 * 登录用户姓名
	 */
	private String loginAccountName;

	public LoginUserBO() {
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginAccountName() {
		return loginAccountName;
	}

	public void setLoginAccountName(String loginAccountName) {
		this.loginAccountName = loginAccountName;
	}
}
