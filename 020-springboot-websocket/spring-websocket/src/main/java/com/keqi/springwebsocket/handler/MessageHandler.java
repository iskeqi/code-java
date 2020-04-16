package com.keqi.springwebsocket.handler;

import com.keqi.springwebsocket.message.WebSocketMessageParam;
import org.springframework.web.socket.WebSocketSession;

/**
 * 消息处理器接口
 */
public interface MessageHandler {

    /**
     * 执行处理消息
     *
     * @param session 会话
     * @param message 消息
     */
    void execute(WebSocketSession session, WebSocketMessageParam message);

    /**
     * @return 消息类型，即每个 Message 实现类上的 TYPE 静态字段
     */
    String getType();

}
