package com.keqi.springwebsocketagain.websocket.handler;

import com.keqi.springwebsocketagain.websocket.WebSocketMessageHandler;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 报表-正在传输中任务
 *
 * @author keqi
 */
@Component("webSocketMessageHandler_report_taskInTransit")
public class TaskInTransit implements WebSocketMessageHandler {

	@Override
	public Map<String, Object> execute(String webSocketSessionId, Map<String, Object> param) {
		// 执行对应的请求-应答机制
		return param;
	}
}
