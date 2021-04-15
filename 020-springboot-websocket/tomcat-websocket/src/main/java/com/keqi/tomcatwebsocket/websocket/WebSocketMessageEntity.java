package com.keqi.tomcatwebsocket.websocket;

import lombok.Data;

import java.util.Map;

/**
 * WebSocketMessageEntity
 *
 * @author keqi
 */
@Data
public class WebSocketMessageEntity {

	/**
	 * 当前 WebSocket 连接处于哪个页面
	 */
	private String page;

	/**
	 * 当前 WebSocket 连接中指定页面中的推送消息类型
	 */
	private String type;

	/**
	 * 当前 WebSocket 连接下的本次请求唯一id
	 */
	private String requestId;

	/**
	 * 存放请求参数或者响应参数
	 */
	private Map<String, Object> data;
}
