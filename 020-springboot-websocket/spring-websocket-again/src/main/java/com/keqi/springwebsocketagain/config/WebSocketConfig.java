package com.keqi.springwebsocketagain.config;

import com.keqi.springwebsocketagain.websocket.DataExchangeWebSocketHandler;
import com.keqi.springwebsocketagain.websocket.DataExchangeWebSocketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * WebSocket 配置类
 *
 * @author keqi
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Autowired
	private DataExchangeWebSocketHandler dataExchangeWebSocketHandler;
	@Autowired
	private DataExchangeWebSocketInterceptor dataExchangeWebSocketInterceptor;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(dataExchangeWebSocketHandler, "/") // 配置处理器
				.addInterceptors(dataExchangeWebSocketInterceptor) // 配置拦截器
				.setAllowedOrigins("*"); // 解决跨域问题
	}

}
