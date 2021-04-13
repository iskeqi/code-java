package com.keqi.springwebsocketagain.websocket;

import com.keqi.springwebsocketagain.uitl.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.Objects;

/**
 * WebSocketHandler 类
 *
 * @author keqi
 */
@Slf4j
@Component
public class DataExchangeWebSocketHandler extends TextWebSocketHandler {

	@Autowired
	private Map<String, WebSocketMessageHandler> webSocketMessageHandlerMap;

	/**
	 * 对应 open 事件
	 *
	 * @param webSocketSession
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession webSocketSession) {
		WebSocketUtil.addWebSocketSession(webSocketSession);
	}

	/**
	 * 对应 message 事件
	 *
	 * @param webSocketSession
	 * @param textMessage
	 */
	@Override
	public void handleTextMessage(WebSocketSession webSocketSession, TextMessage textMessage) {
		try {
			WebSocketMessageEntity webSocketMessageEntity = JsonUtil.readValue(textMessage.getPayload(), WebSocketMessageEntity.class);

			// 设置当前连接处于哪个页面
			String page = webSocketMessageEntity.getPage();
			if (!Objects.equals(page, "heartbeat")) {
				WebSocketUtil.updateWebSocketSessionPage(webSocketSession, page);
			}

			WebSocketMessageHandler webSocketMessageHandler = webSocketMessageHandlerMap.get("webSocketMessageHandler_"
					+ webSocketMessageEntity.getPage() + "_" + webSocketMessageEntity.getType());
			if (Objects.nonNull(webSocketMessageHandler)) {
				WebSocketUtil.send(webSocketSession.getId(), webSocketMessageHandler.execute(webSocketSession.getId(), webSocketMessageEntity));
			}
		} catch (Throwable throwable) {
			log.error(throwable.getMessage(), throwable);
		}
	}

	/**
	 * 对应 close 事件
	 *
	 * @param webSocketSession
	 * @param status
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus status) {
		WebSocketUtil.removeWebSocketSession(webSocketSession);
	}

	/**
	 * 对应 error 事件
	 *
	 * @param webSocketSession
	 * @param throwable
	 */
	@Override
	public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) {
		WebSocketUtil.removeWebSocketSession(webSocketSession);
		log.error(throwable.getMessage(), throwable);
	}

}
