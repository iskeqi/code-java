package com.qjzh.idomp.zjc.core.common;

/**
 * 登录用户信息实体类
 *
 * @author keqi
 */
public class LoginUserBO {

	// 登录名
	private String loginName;

	// 姓名
	private String name;

	public LoginUserBO() {
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
