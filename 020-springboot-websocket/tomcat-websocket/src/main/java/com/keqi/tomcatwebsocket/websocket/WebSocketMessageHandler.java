package com.keqi.tomcatwebsocket.websocket;

/**
 * WebSocket 消息处理器接口
 *
 * @author keqi
 */
public interface WebSocketMessageHandler {

	/**
	 * 处理 WebSocket 推送过来的消息
	 *
	 * @param webSocketSessionId     WebSocketSession 对应的唯一id
	 * @param webSocketMessageEntity 请求参数
	 * @return r 响应参数
	 */
	WebSocketMessageEntity execute(String webSocketSessionId, WebSocketMessageEntity webSocketMessageEntity);
}
