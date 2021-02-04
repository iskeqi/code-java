package com.keqi.seed.sys.pojo;

import com.keqi.seed.core.exception.NoAuthException;
import com.keqi.seed.core.pojo.CoreConstant;
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
	 * 获取当前登录用户id
	 *
	 * @return r
	 */
	public static Long getAccountId() {
		Map<String, Object> loginInfo = threadLocal.get();
		Long obj;
		if (loginInfo == null || (obj = (Long) loginInfo.get(CoreConstant.LOGIN_ACCOUNT_ID)) == null) {
			throw new NoAuthException();
		}
		return obj;
	}

	/**
	 * 设置当前登录用户id
	 *
	 * @param accountId accountId
	 */
	public static void setAccountId(Long accountId) {
		Map<String, Object> loginInfo = threadLocal.get();
		if (Objects.isNull(loginInfo)) {
			loginInfo = new HashMap<>();
			threadLocal.set(loginInfo);
		}
		loginInfo.put(CoreConstant.LOGIN_ACCOUNT_ID, accountId);
	}
}
