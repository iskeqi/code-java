package com.keqi.springbootmybatisognl.common;

public class Auth {

	/**
	 * 获取系统当前操作用户名
	 *
	 *  <bind name="loginAccount" value="@com.keqi.springbootmybatisognl.common.Auth@getLoginAccount()"/>
	 *
	 * @return r
	 */
	public static String getLoginAccount() {
		return "ognlAccount";
	}

}
