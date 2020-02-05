package com.keqi.springbootwebsocket.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.Session;
import java.io.IOException;

/**
 * 客户端对象的封装
 */
public class WebSocketClient {

	Logger logger = LoggerFactory.getLogger(WebSocketClient.class);

	// 客户端连接sessionId
	private String sessionId;

	// 与某个客户端的连接会话，需要它可以给客户端发送数据
	private Session session;

	// 代表客户端的业务数据，表示需要哪一块数据
	private String msgCode;

	public WebSocketClient(String sessionId, Session session, String msgCode) {
		this.sessionId = sessionId;
		this.msgCode = msgCode;
		this.session = session;
	}

	/**
	 * 发送消息到客户端
	 * @param message message
	 */
	public synchronized void sendInfo(String message) {
		/*
			最终发消息是这里完成的，所以在最后一道关卡把关即可
			如果此时session为空或者已经关闭了，就直接结束，不再发送消息即可

			造成这种现象的原因可能是：程序正在处理该连接需要的数据，当转备好数据后，准备发送时，发现这个连接已经断开了
		*/
		if (this.session == null || !this.session.isOpen()) {
			return;
		}

		try {
			this.session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			logger.error("发送消息失败，sessionId为{}, msgCode为{}", sessionId, msgCode);
			e.printStackTrace();
		}
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
}
