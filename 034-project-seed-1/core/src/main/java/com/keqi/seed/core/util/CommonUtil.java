package com.keqi.seed.core.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.system.ApplicationHome;

import javax.servlet.http.HttpServletRequest;

/**
 * 公共工具类
 *
 * @author keqi
 */
public class CommonUtil {

	/**
	 * 动态获取到 jar 包所在的绝对目录
	 * <p>
	 * 比如：app.jar 文件的绝对路径是： /home/course/iot/app.jar，那么这里返回的就是：/home/course/iot
	 * 没有斜杠作为后缀
	 * <p>
	 * windows 启动时，路径是 D:\KEQI\code\code-java\029-springboot-static-resource
	 *
	 * @return r
	 */
	public static String getApplicationHomeAbsolutePath() {
		ApplicationHome applicationHome = new ApplicationHome();
		return applicationHome.getDir().getAbsolutePath();
	}


	/**
	 * 请求通过反向代理之后，可能包含请求客户端真实IP的HTTP HEADER
	 * 如果后续扩展，有其他可能包含IP的HTTP HEADER，加到这里即可
	 */
	private static final String[] POSSIBLE_HEADERS = {
			"X-Forwarded-For", "X-Real-IP", "Proxy-Client-IP",
			"WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"
	};

	/**
	 * 获取请求客户端的真实IP地址
	 *
	 * @param request javax.servlet.http.HttpServletRequest
	 * @return 客户端端真实IP地址
	 */
	public static String getRequestClientRealIP(HttpServletRequest request) {
		String ip;
		// 先检查代理：逐个HTTP HEADER检查过去，看看是否存在客户端真实IP
		for (String header : POSSIBLE_HEADERS) {
			ip = request.getHeader(header);
			if (StrUtil.isNotBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
				// 请求经过多次反向代理后可能会有多个IP值（以英文逗号分隔），第一个IP才是客户端真实IP
				return ip.contains(",") ? ip.split(",")[0] : ip;
			}
		}
		// 从所有可能的HTTP HEADER中都没有找到客户端真实IP，采用request.getRemoteAddr()来兜底
		ip = request.getRemoteAddr();
		if ("0:0:0:0:0:0:0:1".equals(ip) || "127.0.0.1".equals(ip)) {
			// 说明是从本机发出的请求，直接获取并返回本机IP地址
			return "127.0.0.1";
		}
		return ip;
	}
}
