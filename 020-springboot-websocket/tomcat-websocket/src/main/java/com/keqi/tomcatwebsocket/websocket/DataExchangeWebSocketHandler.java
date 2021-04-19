package com.keqi.tomcatwebsocket.websocket;

import com.keqi.tomcatwebsocket.uitl.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;

/**
 * WebSocketHandler 类
 *
 * @author keqi
 */
@Slf4j
@Component
@ServerEndpoint("/")
public class DataExchangeWebSocketHandler {

	/**
	 * 对应 open 事件
	 *
	 * @param session
	 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) throws IOException {
		// Session 对象无法设置一些与它强关联的信息，那么完全可以自定义一个类，将其它信息和 Session 对象封装到一起

		// 连接认证
		int userId;
		try {
			userId = Integer.parseInt(session.getRequestParameterMap().get("userId").get(0));
		} catch (Throwable throwable) {
			log.error("认证不通过，SessionId 为 {}", session.getId());
			session.close();
			return;
		}

		// 设置空闲超时时间为 5 分钟
		session.setMaxIdleTimeout(300000);
		WebSocketUtil.addSession(session, userId);
	}

	/**
	 * 对应 message 事件
	 *
	 * @param session
	 * @param message
	 */
	@OnMessage
	public void onMessage(Session session, String message) {
		try {
			WebSocketMessageEntity webSocketMessageEntity = JsonUtil.readValue(message, WebSocketMessageEntity.class);

			// 设置当前连接处于哪个页面
			String page = webSocketMessageEntity.getPage();
			if (!Objects.equals(page, "heartbeat")) {
				WebSocketUtil.SESSION_PAGE_MAP.put(session, page);
			}

			WebSocketMessageHandler handler = WebSocketMessageHandlerContext.get("webSocketMessageHandler_"
					+ webSocketMessageEntity.getPage() + "_" + webSocketMessageEntity.getType());
			if (Objects.nonNull(handler)) {
				WebSocketUtil.send(session.getId(), handler.execute(session.getId(), webSocketMessageEntity));
			}
		} catch (Throwable throwable) {
			log.error(throwable.getMessage(), throwable);
		}
	}

	/**
	 * 对应 close 事件
	 *
	 * @param session
	 * @param closeReason
	 */
	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		WebSocketUtil.removeSession(session);
	}

	/**
	 * 对应 error 事件
	 *
	 * @param session
	 * @param throwable
	 */
	@OnError
	public void onError(Session session, Throwable throwable) {
		WebSocketUtil.removeSession(session);
		log.error(throwable.getMessage(), throwable);
	}

}
