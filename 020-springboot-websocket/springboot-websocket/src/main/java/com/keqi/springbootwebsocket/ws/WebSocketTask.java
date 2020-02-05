package com.keqi.springbootwebsocket.ws;

import com.alibaba.fastjson.JSON;
import com.keqi.springbootwebsocket.domain.WebSocketMessageEntity;
import com.keqi.springbootwebsocket.strategy.WebSocketStrategy;

import java.util.List;

/**
 * 线程对象
 */
public class WebSocketTask implements Runnable {

	// 代表了客户端连接的WebSocketClient对象
	private WebSocketClient webSocketClient;

	// msgCode对应的WebSocketStrategy对象
	private WebSocketStrategy strategy;

	// msgCode值
	private String msgCode;

	public WebSocketTask(String msgCode, WebSocketClient webSocketClient, WebSocketStrategy strategy) {
		this.msgCode = msgCode;
		this.webSocketClient = webSocketClient;
		this.strategy = strategy;
	}

	@Override
	public void run() {
		// 调用msgCode对应的WebSocketStrategy类的方法去处理业务逻辑
		List<WebSocketMessageEntity> allResponseData = strategy.getAllResponseData(this.msgCode);

		// 将每一条消息都推送到客户端
		for (WebSocketMessageEntity webSocketMessageEntity : allResponseData) {
			webSocketClient.sendInfo(JSON.toJSONString(webSocketMessageEntity));
		}
	}

}
