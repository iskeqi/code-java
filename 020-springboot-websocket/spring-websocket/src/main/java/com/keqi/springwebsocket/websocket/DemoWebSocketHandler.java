package com.keqi.springwebsocket.websocket;

import com.keqi.springwebsocket.util.WebSocketUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 负责建立逻辑WebSocket连接/接收消息等
 *
 * 如无特殊必要，不建议通过WebSocket连接来实现HTTP最擅长的请求应答机制。只通过WebSocket连接向WEB客户端推送需要实时更新的数据即可
 *
 * 对于第一次进入页面时，需要展示的数据，由客户端调用专用的HTTP接口并传入msgCode参数，来从Redis或者DB或者内存中的对象来获取最新的一份数据
 */
@Slf4j
@Component
public class DemoWebSocketHandler extends TextWebSocketHandler {

    @Override // 对应 open 事件
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 无需自己管理 session 超时时间，Spring封装的类库已经帮你做好了，你只要在使用的时候，调用 isOpen() 方法判断连接是否还在就行

        log.info("{open}本次操作线程名称：{}，本次操作线程ID：{}", Thread.currentThread().getName(), Thread.currentThread().getId());
        log.info("[afterConnectionEstablished][session({}) 接入]", session);
        // 解析 accessToken （这里直接使用token作为用户信息，如果需要存储用户的其他信息，就需要稍微修改一下session和用户信心的关联方式，比如用3个map存储）
        String accessToken = (String) session.getAttributes().get("accessToken");

        // WebSocketSession 对象有一个 Map<String, Object> getAttributes() 方法，能够用来存储数据，一般会用来存储一些和这个 session 对象直接相关的信息
        // 只能通过 HandshakeInterceptor 接口的 boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
        //			WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception; 方法的 attributes 参数来进行设置


        WebSocketUtil.addSession(session, accessToken);
    }

    @Override // 对应 message 事件
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws Exception {
        // 通过打印出的日志可见，其实 Tomcat 容器已经为你建立了一个处理 websocket 消息的线程池，而且用的就是 HTTP 的线程池，他们是共用的一个线程池！！！
        // 你只需要负责编写无状态的的代码就行，根本就不需要关心线程池的问题，因为人家已经帮你做好了
        // 处理 websocket 消息的逻辑和你编写一个controller接口的逻辑是一模一样的，不带任何状态就对了！！！
        // 根本就没啥区别呀，明白了吗？！！！
        log.info("{message}本次操作线程名称：{}，本次操作线程ID：{}", Thread.currentThread().getName(), Thread.currentThread().getId());
        log.info("[handleMessage][session({}) 接收到一条消息({})]", session, textMessage); // 生产环境下，请设置成 debug 级别
        try {
            String payload = textMessage.getPayload();
            if ("PING".equals(payload)) {
                // 用于心跳，防止长时间未操作，就断线了
                session.sendMessage(new TextMessage("PONG"));
                return;
            }
            // 如果非要通过这种方式，进行请求/应答机制，那么就就使用IOC容器来根据msgCode获取到对应的Handle来处理消息(仍然不建议)
            System.out.println("xxx");
        } catch (Throwable throwable) {
            log.info("[onMessage][session({}) message({}) 发生异常]", session, throwable);
        }
    }

    @Override // 对应 close 事件
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 如果客户端主动断开连接，那么就会触发这个方法
        log.info("[afterConnectionClosed][session({}) 连接关闭。关闭原因是({})}]", session, status);
        WebSocketUtil.removeSession(session);
    }

    @Override // 对应 error 事件
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // 发生 error 事件，就会触发这个方法
        log.info("[handleTransportError][session({}) 发生异常]", session, exception);
    }

}
