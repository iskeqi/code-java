package com.keqi.springwebsocketagain.websocket;

/**
 * WebSocket 消息处理器接口
 *
 * @author keqi
 */
public interface WebSocketMessageHandler {

	/**
	 * 处理 WebSocket 推送过来的消息
	 *
	 * @param webSocketSessionId
	 * @param webSocketMessageEntity
	 * @return
	 */
	WebSocketMessageEntity execute(String webSocketSessionId, WebSocketMessageEntity webSocketMessageEntity);
}
