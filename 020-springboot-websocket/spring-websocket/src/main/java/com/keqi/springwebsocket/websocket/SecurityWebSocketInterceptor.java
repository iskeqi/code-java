package com.keqi.springwebsocket.websocket;

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
 * 自定义一个WebSocket拦截器，用于建立连接/接收消息前进行一些通用业务操作
 */
@Slf4j
@Component
public class SecurityWebSocketInterceptor extends HttpSessionHandshakeInterceptor {

    // http://www.websocket-test.com/ websocket在线测试地址

    @Override // 拦截 Handshake 事件
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        // 因为 WebSocketSession 无法获得 ws 地址上的请求参数，所以只好通过该拦截器，获得 accessToken 请求参数，设置到 attributes 中

        // 获得 accessToken
        String accessToken;

        ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
        accessToken = serverRequest.getServletRequest().getParameter("accessToken");
        if (StringUtils.isEmpty(accessToken)) {
            accessToken = "accessToken";
        }
        attributes.put("accessToken", accessToken);

        // 可见，只有在 WebSocket 握手阶段，才会调用此方法，发送消息时，是不会经过此方法的
        log.info("{拦截器}本次操作线程名称：{}，本次操作线程ID：{}", Thread.currentThread().getName(), Thread.currentThread().getId());

        // 这里面模拟没有登录的场景，直接结束
        if ("accessToken".equals(accessToken)) {
            // 可见，在 WebSocket 的握手阶段，调用此方法，在此方法中实现鉴权是完全可行的，鉴权不通过时，返回 false 就行
            // 对于 SpringMVC 中的拦截器Interceptor无法拦截 WebSocket 请求的哦，握手阶段也没有用，只能在此阶段进行拦截，进行鉴权
            // 但是如果使用了 JavaWEB 的过滤器Filter，是能够有效的在握手阶段进行拦截的

            // 所以到底需不需要在此处进行鉴权，就要看你整个项目中是使用的拦截器进行鉴权还是过滤器进行鉴权了哦。
            // SpringSecurity 进行鉴权时，好像采用的就是 Filter 哦
            log.info("这里鉴权不通过，直接就结束了");
            return false;
        }

        // 调用父方法，继续执行逻辑
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

}
