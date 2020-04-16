package com.keqi.springwebsocket.websocket;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * 自定义一个WebSocket拦截器，用于建立连接/接收消息前进行一些通用业务操作
 */
@Slf4j
@Component
public class SecurityWebSocketInterceptor extends HttpSessionHandshakeInterceptor {

    @Override // 拦截 Handshake 事件
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        // 因为 WebSocketSession 无法获得 ws 地址上的请求参数，所以只好通过该拦截器，获得 accessToken 请求参数，设置到 attributes 中

        // 获得 accessToken
        String accessToken = null;
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            accessToken = serverRequest.getServletRequest().getParameter("accessToken");
            attributes.put("accessToken", accessToken);
        }

        log.info("{拦截器}本次操作线程名称：{}，本次操作线程ID：{}", Thread.currentThread().getName(), Thread.currentThread().getId());

        // 这里面模拟没有登录的场景，直接结束
        if ("accessToken".equals(accessToken)) {
            return false;
        }

        // 调用父方法，继续执行逻辑
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

}
