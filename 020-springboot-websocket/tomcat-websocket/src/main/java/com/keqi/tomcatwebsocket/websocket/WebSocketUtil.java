package com.keqi.tomcatwebsocket.websocket;

import com.keqi.tomcatwebsocket.uitl.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.websocket.Session;
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
	 * 用户id 和该账号下建立的 session 连接
	 */
	private static final Map<Integer, List<Session>> USER_SESSION_MAP = new ConcurrentHashMap<>();

	/**
	 * session 的额外信息，因 getAttributes() 方法中的 Map 只能在握手阶段设置值，其它情况下无法设置值
	 * 因当前仅需存储当前连接处于哪个页面这一个信息，所以未使用Map而是直接使用 String
	 */
	static final Map<Session, String> SESSION_PAGE_MAP = new ConcurrentHashMap<>();

	/**
	 * 用户存储 session 及其 id 的关联关系，避免将 session 对象传递到其它位置
	 */
	private static final Map<String, Session> ID_SESSION_MAP = new ConcurrentHashMap<>();

	/**
	 * 给所有客户端推送消息
	 *
	 * @param webSocketMessageEntity
	 */
	public static void sendAll(WebSocketMessageEntity webSocketMessageEntity) {
		for (List<Session> list : USER_SESSION_MAP.values()) {
			for (Session session : list) {
				sendTextMessage(session, webSocketMessageEntity);
			}
		}
	}

	/**
	 * 给指定的连接推送消息
	 *
	 * @param sessionId
	 * @param webSocketMessageEntity
	 */
	public static void send(String sessionId, WebSocketMessageEntity webSocketMessageEntity) {
		Session session = ID_SESSION_MAP.get(sessionId);
		if (Objects.nonNull(session)) {
			sendTextMessage(session, webSocketMessageEntity);
		}
	}

	/**
	 * 添加 session
	 *
	 * @param session
	 */
	static void addSession(Session session, Integer userId) {
		List<Session> list = USER_SESSION_MAP.get(userId);
		if (Objects.isNull(list)) {
			list = new ArrayList<>();
		}
		list.add(session);
		USER_SESSION_MAP.put(userId, list);
		ID_SESSION_MAP.put(session.getId(), session);
	}

	/**
	 * 移除 session
	 *
	 * @param session
	 */
	static void removeSession(Session session) {
		List<String> userIdList = session.getRequestParameterMap().get("userId");
		if (!CollectionUtils.isEmpty(userIdList)) {
			Integer userId = Integer.valueOf(userIdList.get(0));
			List<Session> list = USER_SESSION_MAP.get(userId);
			if (!CollectionUtils.isEmpty(list)) {
				list.remove(session);
			}
		}

		ID_SESSION_MAP.remove(session.getId());
		SESSION_PAGE_MAP.remove(session);
	}

	private static void sendTextMessage(Session session, WebSocketMessageEntity webSocketMessageEntity) {
		if (session.isOpen()) {
			try {
				String page1 = SESSION_PAGE_MAP.get(session);
				String page2 = webSocketMessageEntity.getPage();
				if (Objects.equals(page2, page1) || Objects.equals("global", page2) || Objects.equals("heartbeat", page2)) {
					// 因为客户端是全局一个 WebSocket 连接，如果推送消息的 page 和当前连接中保存的 page 一致时，才进行数据推送，global 例外
					session.getBasicRemote().sendText(JsonUtil.writeValueAsString(webSocketMessageEntity));
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
}
