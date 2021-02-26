package com.keqi.springsecurityjwt.sys.pojo;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 登录用户信息工具类（通过 ThreadLocal 存储用户信息）
 *
 * @author keqi
 */
@Component
public final class Auth {

	public static Long getAccountId() {
		return getLoginUserBO().getId();
	}

	public static void setLoginUserBO(LoginUserBO loginUserBO) {
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(new UsernamePasswordAuthenticationToken(loginUserBO, null));
	}

	private static LoginUserBO getLoginUserBO() {
		SecurityContext context = SecurityContextHolder.getContext();
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) context.getAuthentication();
		return (LoginUserBO) authentication.getPrincipal();
	}
}
