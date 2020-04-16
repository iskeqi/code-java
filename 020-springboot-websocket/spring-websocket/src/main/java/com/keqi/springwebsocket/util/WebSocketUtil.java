package com.keqi.springwebsocket.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.keqi.springwebsocket.message.WebSocketMessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket 工具类，提供客户端连接的管理等功能
 */
@Slf4j
public class WebSocketUtil {

    // ========== 会话相关 ==========

    /**
     * Session 与用户的映射
     */
    private static final Map<WebSocketSession, String> SESSION_USER_MAP = new ConcurrentHashMap<>();
    /**
     * 用户与 Session 的映射
     */
    private static final Map<String, WebSocketSession> USER_SESSION_MAP = new ConcurrentHashMap<>();

    /**
     * 添加 Session 。在这个方法中，会添加用户和 Session 之间的映射
     *
     * @param session Session
     * @param user 用户
     */
    public static void addSession(WebSocketSession session, String user) {
        // 更新 USER_SESSION_MAP
        USER_SESSION_MAP.put(user, session);
        // 更新 SESSION_USER_MAP
        SESSION_USER_MAP.put(session, user);
    }

    /**
     * 移除 Session
     *
     * @param session Session
     */
    public static void removeSession(WebSocketSession session) {
        // 从 SESSION_USER_MAP 中移除
        String user = SESSION_USER_MAP.remove(session);
        // 从 USER_SESSION_MAP 中移除
        if (user != null && user.length() > 0) {
            USER_SESSION_MAP.remove(user);
        }
    }

    // ========== 消息相关 ==========

    /**
     * 广播发送消息给所有在线用户
     *
     * @param message 消息体
     */
    public static void broadcast(WebSocketMessageEntity message) {
        // 创建消息
        TextMessage textMessage = buildTextMessage(message);
        // 遍历 SESSION_USER_MAP ，进行逐个发送
        for (WebSocketSession session : SESSION_USER_MAP.keySet()) {
            sendTextMessage(session, textMessage);
        }
    }

    /**
     * 发送消息给单个用户的 Session
     *
     * @param session Session
     * @param message 消息体
     */
    public static void send(WebSocketSession session, WebSocketMessageEntity message) {
        // 创建消息
        TextMessage textMessage = buildTextMessage(message);
        // 遍历给单个 Session ，进行逐个发送
        sendTextMessage(session, textMessage);
    }

    /**
     * 发送消息给指定用户
     *
     * @param user 指定用户
     * @param message 消息体
     * @return 发送是否成功你那个
     */
    public static boolean send(String user, WebSocketMessageEntity message) {
        // 获得用户对应的 Session
        WebSocketSession session = USER_SESSION_MAP.get(user);
        if (session == null) {
            log.error("[send][user({}) 不存在对应的 session]", user);
            return false;
        }
        // 发送消息
        send(session, message);
        return true;
    }

    /**
     * 构建完整的消息
     *
     * @param message 消息体
     * @return 消息
     */
    private static TextMessage buildTextMessage(WebSocketMessageEntity message) {
        return new TextMessage(JSON.toJSONString(message, SerializerFeature.WriteMapNullValue));
    }

    /**
     * 真正发送消息
     *
     * @param session Session
     * @param textMessage 消息
     */
    private static void sendTextMessage(WebSocketSession session, TextMessage textMessage) {
        if (session == null) {
            log.error("[sendTextMessage][session 为 null]");
            return;
        }
        try {
            session.sendMessage(textMessage);
        } catch (IOException e) {
            log.error("[sendTextMessage][session({}) 发送消息{}) 发生异常",
                    session, textMessage, e);
        }
    }

}
