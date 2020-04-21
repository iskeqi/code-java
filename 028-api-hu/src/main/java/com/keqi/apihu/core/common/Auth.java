package com.keqi.apihu.core.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class Auth {

	private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

	/**
	 * 获取当前线程操作用户登录名
	 * <bind name="loginAccount" value="@com.keqi.apihu.core.common.Auth@getLoginAccount()"/>
	 *
	 * @return r
	 */
	public static String getLoginAccount() {
		return getLoginUserBO() == null ? null : getLoginUserBO().getAccount();
	}


	public static String getLoginAccountName() {
		return getLoginUserBO() == null ? null : getLoginUserBO().getNickName();
	}


	/**
	 * 获取当前登录用户登录信息
	 *
	 * @return r
	 */
	public static LoginUserBO getLoginUserBO() {
		Map<String, Object> stringObjectMap = threadLocal.get();
		if (Objects.isNull(stringObjectMap)) {
			return null;
		}
		return (LoginUserBO) stringObjectMap.get(CommonConstant.LOGIN_USER);
	}


	/**
	 * 设置当前登录用户信息
	 *
	 * @param loginUserBO loginUserBO
	 */
	public static void setLoginUserBO(LoginUserBO loginUserBO) {
		Map<String, Object> stringObjectMap = threadLocal.get();
		if (Objects.isNull(stringObjectMap)) {
			stringObjectMap = new HashMap<>();
			threadLocal.set(stringObjectMap);
		}
		stringObjectMap.put(CommonConstant.LOGIN_USER, loginUserBO);
	}


}
