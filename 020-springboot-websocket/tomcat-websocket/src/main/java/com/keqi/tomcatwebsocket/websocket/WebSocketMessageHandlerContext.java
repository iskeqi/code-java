package com.keqi.tomcatwebsocket.websocket;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * WebSocketMessageHandlerContext
 *
 * @author keqi
 */
@Component
public class WebSocketMessageHandlerContext implements ApplicationContextAware {

	private static Map<String, WebSocketMessageHandler> webSocketMessageHandlerMap;

	public static WebSocketMessageHandler get(String webSocketMessageHandler) {
		return webSocketMessageHandlerMap.get(webSocketMessageHandler);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		webSocketMessageHandlerMap = applicationContext.getBeansOfType(WebSocketMessageHandler.class);
	}
}
