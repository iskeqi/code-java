package com.keqi.springwebsocket.config;

import com.keqi.springwebsocket.websocket.DemoWebSocketHandler;
import com.keqi.springwebsocket.websocket.SecurityWebSocketInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket // 开启 Spring WebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Autowired
    private DemoWebSocketHandler demoWebSocketHandler;
    @Autowired
    private SecurityWebSocketInterceptor securityWebSocketInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(demoWebSocketHandler, "/") // 配置处理器
                .addInterceptors(securityWebSocketInterceptor) // 配置拦截器
                .setAllowedOrigins("*"); // 解决跨域问题
    }

}
