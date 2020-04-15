package com.keqi.springwebsocket.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * WebSocket 消息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class WebSocketMessageEntity {

	private String msgCode;

	private Date msgTime;

	private Object msgBody;
}
