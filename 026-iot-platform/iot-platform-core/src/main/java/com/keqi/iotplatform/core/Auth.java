package com.keqi.iotplatform.core;

import com.keqi.iotplatform.core.constant.CoreCommonConstant;
import com.keqi.iotplatform.core.domain.LoginUserBO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 当前登录用户工具类(还是改换成ThreadLocal吧)
 */
@Component
public class Auth {

	private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

	/**
	 * 获取当前线程操作用户登录名
	 * <bind name="loginAccount" value="@com.keqi.projectseedsecond.common.Auth@getLoginAccount()"/>
	 *
	 * @return r
	 */
	public static String getLoginAccount() {
		return getLoginUserBO() == null ? null : getLoginUserBO().getLoginAccount();
	}

	/**
	 * 获取当前线程操作用户姓名
	 *
	 * @return r
	 */
	public static String getLoginAccountName() {
		return getLoginUserBO() == null ? null : getLoginUserBO().getLoginAccountName();
	}

	/**
	 * 获取当前线程操作用户信息
	 *
	 * @return r
	 */
	public static LoginUserBO getLoginUserBO() {
		Map<String, Object> stringObjectMap = threadLocal.get();
		if (Objects.isNull(stringObjectMap)) {
			return null;
		}
		return (LoginUserBO) stringObjectMap.get(CoreCommonConstant.LOGIN_USER);
	}

	/**
	 * 设置当前登录用户信息至当前操作线程中
	 *
	 * @param loginUserBO loginUserBO
	 */
	public static void setLoginUserBO(LoginUserBO loginUserBO) {
		Map<String, Object> stringObjectMap = threadLocal.get();
		if (Objects.isNull(stringObjectMap)) {
			stringObjectMap = new HashMap<>();
			threadLocal.set(stringObjectMap);
		}
		stringObjectMap.put(CoreCommonConstant.LOGIN_USER, loginUserBO);
	}


}
