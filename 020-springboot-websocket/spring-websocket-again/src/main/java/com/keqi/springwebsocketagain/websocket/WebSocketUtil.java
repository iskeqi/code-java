package com.keqi.springwebsocketagain.websocket;

import cn.hutool.core.map.MapUtil;
import com.keqi.springwebsocketagain.uitl.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
	private static final Map<Integer, Set<WebSocketSession>> USER_SESSION_MAP = new ConcurrentHashMap<>();

	/**
	 * WebSocketSession 当前处于哪个页面
	 */
	static final Map<WebSocketSession, String> SESSION_PAGE_MAP = new ConcurrentHashMap<>();

	/**
	 * 当前页面下存在哪些 WebSocketSession 连接
	 */
	static final Map<String, Set<WebSocketSession>> PAGE_SESSION_MAP = new ConcurrentHashMap<>();

	/**
	 * webSocketSessionId 和 WebSocketSession 之间的关系
	 */
	private static final Map<String, WebSocketSession> ID_SESSION_MAP = new ConcurrentHashMap<>();

	/**
	 * 给所有客户端推送消息
	 *
	 * @param webSocketMessageEntity
	 */
	public static void sendAll(WebSocketMessageEntity webSocketMessageEntity) {
		for (Set<WebSocketSession> list : USER_SESSION_MAP.values()) {
			for (WebSocketSession webSocketSession : list) {
				sendTextMessage(webSocketSession, webSocketMessageEntity);
			}
		}
	}

	/**
	 * 给指定的连接推送消息
	 *
	 * @param webSocketSessionId
	 * @param webSocketMessageEntity
	 */
	public static void send(String webSocketSessionId, WebSocketMessageEntity webSocketMessageEntity) {
		WebSocketSession webSocketSession = ID_SESSION_MAP.get(webSocketSessionId);
		if (Objects.nonNull(webSocketSession)) {
			sendTextMessage(webSocketSession, webSocketMessageEntity);
		}
	}

	/**
	 * 给指定用户发送消息
	 *
	 * @param userId
	 * @param webSocketMessageEntity
	 */
	public static void sendByUserId(Integer userId, WebSocketMessageEntity webSocketMessageEntity) {
		for (WebSocketSession webSocketSession : USER_SESSION_MAP.get(userId)) {
			sendTextMessage(webSocketSession, webSocketMessageEntity);
		}
	}

	/**
	 * 给处于指定页面下的所有连接推送消息
	 *
	 * @param page
	 * @param webSocketMessageEntity
	 */
	public static void sendByPage(String page, WebSocketMessageEntity webSocketMessageEntity) {
		for (WebSocketSession webSocketSession : PAGE_SESSION_MAP.get(page)) {
			sendTextMessage(webSocketSession, webSocketMessageEntity);
		}
	}

	/**
	 * 添加 WebSocketSession
	 *
	 * @param webSocketSession
	 */
	static void addWebSocketSession(WebSocketSession webSocketSession) {
		Integer userId = MapUtil.getInt(webSocketSession.getAttributes(), "userId");

		Set<WebSocketSession> set = USER_SESSION_MAP.get(userId);
		if (Objects.isNull(set)) {
			set = new HashSet<>();
		}
		set.add(webSocketSession);
		USER_SESSION_MAP.put(userId, set);

		ID_SESSION_MAP.put(webSocketSession.getId(), webSocketSession);
	}

	/**
	 * 修改 WebSocketSession 处于哪个页面
	 *
	 * @param webSocketSession
	 * @param page
	 */
	static void updateWebSocketSessionPage(WebSocketSession webSocketSession, String page) {
		SESSION_PAGE_MAP.put(webSocketSession, page);

		Set<WebSocketSession> set = PAGE_SESSION_MAP.get(page);
		if (Objects.isNull(set)) {
			set = new HashSet<>();
		}
		set.add(webSocketSession);
	}

	/**
	 * 移除 WebSocketSession
	 *
	 * @param webSocketSession
	 */
	static void removeWebSocketSession(WebSocketSession webSocketSession) {
		Integer userId = MapUtil.getInt(webSocketSession.getAttributes(), "userId");
		Set<WebSocketSession> userSessionMapSet = USER_SESSION_MAP.get(userId);
		if (!CollectionUtils.isEmpty(userSessionMapSet)) {
			userSessionMapSet.remove(webSocketSession);
		}

		ID_SESSION_MAP.remove(webSocketSession.getId());

		String page = SESSION_PAGE_MAP.get(webSocketSession);
		SESSION_PAGE_MAP.remove(webSocketSession);

		Set<WebSocketSession> set = PAGE_SESSION_MAP.get(page);
		if (!CollectionUtils.isEmpty(set)) {
			set.remove(webSocketSession);
		}
	}

	private static void sendTextMessage(WebSocketSession webSocketSession, WebSocketMessageEntity webSocketMessageEntity) {
		if (webSocketSession.isOpen()) {
			try {
				String page1 = SESSION_PAGE_MAP.get(webSocketSession);
				String page2 = webSocketMessageEntity.getPage();
				if (Objects.equals(page2, page1) || Objects.equals("global", page2)) {
					// 因为客户端是全局一个 WebSocket 连接，如果推送消息的 page 和当前连接中保存的 page 一致时，才进行数据推送，global 例外
					webSocketSession.sendMessage(new TextMessage(JsonUtil.writeValueAsString(webSocketMessageEntity)));
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
}
