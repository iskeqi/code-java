package com.keqi.springbootwebsocket.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 每一个客户端连接成功后，都会有一个对应的WebSocketSession对象
 *
 * 别的教程里面都是直接把这个对象持有session对象，然后作为客户端与服务端连接的对象存起来，其实这样不好
 *
 * 我觉得根据自己的业务情况封装一个客户端对象是很好的做法，这里面存储sessionId,session对象，以及其他业务参数
 */
@ServerEndpoint("/websocket/{msgCode}")
@Component
public class WebSocketSession {

	private Logger log = LoggerFactory.getLogger(WebSocketSession.class);

	// 记录当前连接客户端个数
	private static int onlineCount = 0;
	// 用来存放每个客户端对应的WebSocketClient对象
	private static Map<String, WebSocketClient> webSocketMap = new ConcurrentHashMap<>();


	/**
	 * 新客户端连接时就会调用此方法
	 * @param session 代表了客户端与服务端连接的对象
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("msgCode") String msgCode) {
		// 加入WebSocketClient对象到map中
		String sessionId = session.getId();
		webSocketMap.put(sessionId, new WebSocketClient(sessionId, session, msgCode));
		// 连接数加1
		addOnlineCount();
		log.info("有新窗口开始监听,msgCode:" + msgCode + ",当前在线人数为" + getOnlineCount());
		try {
			session.getBasicRemote().sendText("连接成功");
		} catch (IOException e) {
			log.error("websocket IO异常");
		}

		// 这个 Session 对象本身能够设置值吗？

	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose(Session session) {
		//从map中删除
		webSocketMap.remove(session.getId());
		//在线数减1
		subOnlineCount();
		log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message 客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		// 不明白为什么这里阻塞了会影响到其他连接发送消息，所以这里必须要手动开启一个新的线程来执行业务逻辑
		// 你打了断点，当然会堵塞啊，傻逼

		String sessionId = session.getId();
		log.info("收到来自客户端"+ sessionId + "的信息:"+ message);

		// 如果是心跳请求，直接返回成功
		if ("PING".equalsIgnoreCase(message)) {
			session.getBasicRemote().sendText("连接成功");
		}

		// 根据sessionId获取对应的WebSocketClient对象，进行处理
		WebSocketClient webSocketClient = webSocketMap.get(sessionId);
		WebSocketContext.pushMessage(webSocketClient);

		// 新建连接时，无论客户端是否需要，都要推送全局消息
		// 通过当前这个连接推送消息，这里只需要找到全局
		WebSocketContext.pushGlobelMessage(webSocketClient);
	}

	/**
	 *
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		log.error("发生错误");
		error.printStackTrace();
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketSession.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketSession.onlineCount--;
	}

}
