package com.keqi.seed.sys.pojo;

import com.keqi.seed.core.web.exception.NoAuthException;
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

	public static final String LOGIN_ACCOUNT_INFO = "loginAccountInfo";

	public static Long getAccountId() {
		return getLoginUserBO().getId();
	}

	public static void setLoginUserBO(LoginUserBO loginUserBO) {
		Map<String, Object> loginInfo = threadLocal.get();
		if (Objects.isNull(loginInfo)) {
			loginInfo = new HashMap<>();
			threadLocal.set(loginInfo);
		}
		loginInfo.put(LOGIN_ACCOUNT_INFO, loginUserBO);
	}

	private static LoginUserBO getLoginUserBO() {
		Map<String, Object> loginInfo = threadLocal.get();
		if (loginInfo == null) {
			throw new NoAuthException();
		}

		LoginUserBO obj = (LoginUserBO) loginInfo.get(LOGIN_ACCOUNT_INFO);
		if (obj == null) {
			throw new NoAuthException();
		}
		return obj;
	}
}
