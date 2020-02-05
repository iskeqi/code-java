package com.keqi.springbootwebsocket.strategy;


import com.keqi.springbootwebsocket.constants.WebSocketCode;
import com.keqi.springbootwebsocket.domain.WebSocketMessageEntity;

import java.util.List;

/**
 * 所有需要推送消息到客户端的类都需要实现这个接口
 */
public interface WebSocketStrategy {

	/**
	 * 每个处理器返回自己能处理的msgCode
	 * @return 一个实现类可以同时拥有多个msgCode值
	 */
	List<WebSocketCode> getMsgCode();

	/**
	 * 根据msgCode的值来决定发送什么数据
	 * @param msgCode msgCode
	 * @return 多条消息
	 */
	List<WebSocketMessageEntity> getAllResponseData(String msgCode);

}
