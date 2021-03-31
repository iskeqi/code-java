package com.keqi.springwebsocketagain.websocket;

import cn.hutool.core.map.MapUtil;
import com.keqi.springwebsocketagain.uitl.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket 工具类，提供客户端连接的管理等功能
 *
 * @author keqi
 */
@Slf4j
public class WebSocketUtil {

	/**
	 * 用户id 和该账号下建立的 WebSocketSession 连接
	 */
	private static final Map<Integer, List<WebSocketSession>> USER_SESSION_MAP = new ConcurrentHashMap<>();

	/**
	 * WebSocketSession 的额外信息，因 getAttributes() 方法中的 Map 只能在握手阶段设置值，其它情况下无法设置值
	 * 因当前仅需存储当前连接处于哪个页面这一个信息，所以未使用Map而是直接使用 String
	 */
	static final Map<WebSocketSession, String> SESSION_INFO_MAP = new ConcurrentHashMap<>();

	/**
	 * 给所有客户端推送消息
	 *
	 * @param webSocketMessageEntity
	 */
	public static void broadcast(WebSocketMessageEntity webSocketMessageEntity) {
		for (List<WebSocketSession> list : USER_SESSION_MAP.values()) {
			for (WebSocketSession webSocketSession : list) {
				sendTextMessage(webSocketSession, webSocketMessageEntity);
			}
		}
	}

	/**
	 * 给指定的连接推送消息
	 *
	 * @param webSocketSession       webSocketSession
	 * @param webSocketMessageEntity webSocketMessageEntity
	 */
	public static void send(WebSocketSession webSocketSession, WebSocketMessageEntity webSocketMessageEntity) {
		sendTextMessage(webSocketSession, webSocketMessageEntity);
	}

	/**
	 * 添加 WebSocketSession
	 *
	 * @param webSocketSession
	 */
	static void addWebSocketSession(WebSocketSession webSocketSession) {
		Integer userId = MapUtil.getInt(webSocketSession.getAttributes(), "userId");
		List<WebSocketSession> list = USER_SESSION_MAP.get(userId);
		if (Objects.isNull(list)) {
			list = new ArrayList<>();
		}
		list.add(webSocketSession);
		USER_SESSION_MAP.put(userId, list);
	}

	/**
	 * 移除 WebSocketSession
	 *
	 * @param webSocketSession
	 */
	static void removeWebSocketSession(WebSocketSession webSocketSession) {
		Integer userId = MapUtil.getInt(webSocketSession.getAttributes(), "userId");
		List<WebSocketSession> list = USER_SESSION_MAP.get(userId);
		if (!CollectionUtils.isEmpty(list)) {
			list.remove(webSocketSession);
		}
	}

	private static void sendTextMessage(WebSocketSession webSocketSession, WebSocketMessageEntity webSocketMessageEntity) {
		if (webSocketSession.isOpen()) {
			try {
				String page = SESSION_INFO_MAP.get(webSocketSession);
				if (page.equals(webSocketMessageEntity.getPage())) {
					// 因为客户端是全局一个 WebSocket 连接，如果推送消息的 code 和当前连接中保存的 code 一致时，才进行数据推送，避免浪费带宽
					webSocketSession.sendMessage(new TextMessage(JsonUtil.writeValueAsString(webSocketMessageEntity)));
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
}
