package com.keqi.springwebsocketagain.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * WebSocket拦截器，用于在握手阶段进行鉴权或添加一些信息
 *
 * @author keqi
 */
@Slf4j
@Component
public class DataExchangeWebSocketInterceptor extends HttpSessionHandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
								   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

		// 此处应该传递 token，然后进行验证，并将当前登录用户信息放到 ThreadLocal 中存储

		ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) request;
		String userIdStr = servletServerHttpRequest.getServletRequest().getParameter("userId");
		if (StringUtils.hasText(userIdStr)) {
			return false;
		}
		attributes.put("userId", Integer.valueOf(userIdStr));

		if (log.isDebugEnabled()) {
			log.debug("userId：{} 建立连接成功，当期线程id 为：{}", userIdStr, Thread.currentThread().getId());
		}

		return super.beforeHandshake(request, response, wsHandler, attributes);
	}

}
