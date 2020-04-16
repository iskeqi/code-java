package com.keqi.springwebsocket.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * WebSocket 请求消息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class WebSocketMessageParam {

	private String msgCode;

	// 如果通过WebSocket来实现请求/应答机制，就需要这个字段和请求消息一一对应
	private String msgId;

	private Object msgBody;
}
