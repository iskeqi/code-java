package com.keqi.springwebsocketagain.websocket;

import java.util.Map;

/**
 * WebSocket 消息处理器接口
 *
 * @author keqi
 */
public interface WebSocketMessageHandler {

	/**
	 * 处理 WebSocket 推送过来的消息
	 *
	 * @param param 请求参数
	 * @return r 响应参数
	 */
	Map<String, Object> execute(String webSocketSessionId, Map<String, Object> param);
}
