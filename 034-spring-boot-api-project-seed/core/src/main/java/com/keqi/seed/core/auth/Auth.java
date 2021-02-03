package com.keqi.seed.core.auth;

import com.keqi.seed.core.exception.NoAuthException;
import com.keqi.seed.core.pojo.CommonConstant;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 登录用户信息工具类（通过 ThreadLocal 存储用户信息）
 *
 * @author keqi
 */
@Component
public final class Auth {

	private static final ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

	/**
	 * 获取当前登录用户ID
	 *
	 * @return r
	 */
	public static Long getLoginAccountId() {
		return getLoginUserBO().getId();
	}

	/**
	 * 获取当前登录用户账号
	 *
	 * @return r
	 */
	public static String getLoginAccount() {
		return getLoginUserBO().getAccount();
	}

	/**
	 * 获取当前登录用户信息
	 *
	 * @return r
	 */
	private static LoginUserBO getLoginUserBO() {
		Map<String, Object> stringObjectMap = threadLocal.get();
		Object obj;
		if (stringObjectMap == null || (obj = stringObjectMap.get(CommonConstant.LOGIN_USER)) == null) {
			throw new NoAuthException();
		}
		return (LoginUserBO) obj;
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
