package com.keqi.tomcatwebsocket.websocket.handler;

import com.keqi.tomcatwebsocket.websocket.WebSocketMessageEntity;
import com.keqi.tomcatwebsocket.websocket.WebSocketMessageHandler;
import org.springframework.stereotype.Component;

/**
 * 心跳
 *
 * @author keqi
 */
@Component("webSocketMessageHandler_heartbeat_heartbeat")
public class HeartBeatHandler implements WebSocketMessageHandler {

	@Override
	public WebSocketMessageEntity execute(String webSocketSessionId, WebSocketMessageEntity webSocketMessageEntity) {
		return webSocketMessageEntity;
	}
}
