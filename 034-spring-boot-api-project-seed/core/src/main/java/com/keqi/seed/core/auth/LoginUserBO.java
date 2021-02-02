package com.keqi.seed.core.auth;

/**
 * 登录用户信息实体类
 *
 * @author keqi
 */
public class LoginUserBO {

	/**
	 * 用户ID
	 */
	private Long id;

	/**
	 * 登录用户账号名
	 */
	private String account;

	public LoginUserBO() {
	}

	public LoginUserBO(Long id, String account) {
		this.id = id;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}
