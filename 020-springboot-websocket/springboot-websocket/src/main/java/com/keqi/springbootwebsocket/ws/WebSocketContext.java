package com.keqi.springbootwebsocket.ws;

import com.keqi.springbootwebsocket.constants.WebSocketCode;
import com.keqi.springbootwebsocket.strategy.WebSocketStrategy;
import com.keqi.springbootwebsocket.utils.ExecutorUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对于一个msgCode的连接，会同时把他自己以及它的上一级的数据都推送给前端，所以才会有下面这坨复杂代码
 */
@Component
public class WebSocketContext implements ApplicationContextAware {

	// 每一个msgCode都对应一个WebSocketStrategy接口实现类对象
	private static Map<String, WebSocketStrategy> strategies = new HashMap<>();
	// 每一个msgCode都对应着他自己以及上一级的WebSocketStrategy接口实现类对象
	private static Map<String, Map<String, WebSocketStrategy>> parentStrategies = new HashMap<>();

	/**
	 * 这个方法其实就是把WebSocketClient中的msgCode以及它上级的需要推送的数据分成多个线程推送给前端，使用同一个WebSocketClient对象
	 * @param webSocketClient
	 */
	public static void pushMessage(WebSocketClient webSocketClient) {
		// 开启一个或者多个新的线程去处理该连接需要的数据，并返回给客户端

		// 找到这个msgCode以及它的上级目录的msgCode对应的所有的WebSocketStrategy实现类，装进集合中
		String msgCode = webSocketClient.getMsgCode();
		Map<String, WebSocketStrategy> stringWebSocketStrategyMap = parentStrategies.get(msgCode);
		Map<String, WebSocketStrategy> tempParentStrategies = new HashMap<>();
		// 如果stringWebSocketStrategyMap等于null,说用是第一次做这种操作，所以需要遍历strategies，并保存起来
		if (stringWebSocketStrategyMap == null) {
			for (Map.Entry<String, WebSocketStrategy> entry : strategies.entrySet()) {
				String key = entry.getKey();
				WebSocketStrategy strategy = entry.getValue();
				if (msgCode.startsWith(key)) {
					tempParentStrategies.put(key, strategy);
				}
			}
			parentStrategies.put(msgCode, tempParentStrategies);
		}

		Map<String, WebSocketStrategy> temp = stringWebSocketStrategyMap == null ? tempParentStrategies : stringWebSocketStrategyMap;
		// 开启一个或者多个线程去处理多个msgCode的值，然后通过一个WebSocketClient对象推送多次数据到前端
		for (Map.Entry<String, WebSocketStrategy> entry : temp.entrySet()) {
			ExecutorUtil.submit(new WebSocketTask(entry.getKey(), webSocketClient, entry.getValue()));
		}

	}

	/**
	 * 推送全局消息
	 * @param webSocketClient webSocketClient
	 */
	public static void pushGlobelMessage(WebSocketClient webSocketClient) {
		// 找到全局处理类，然后推送数据即可
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (!strategies.isEmpty()) {
			strategies.clear();
		}

		// 获取WebSocketStrategy接口所有的实现类
		Map<String, WebSocketStrategy> beans = applicationContext.getBeansOfType(WebSocketStrategy.class);
		for (WebSocketStrategy strategy : beans.values()) {
			// 得到WebSocketStrategy实现了的msgCode集合
			List<WebSocketCode> WebSocketCodeList = strategy.getMsgCode();
			// 遍历msgCode集合，全部放到strategies这个map中
			for (WebSocketCode webSocketCode : WebSocketCodeList) {
				strategies.put(webSocketCode.getMsgCode(), strategy);
			}
		}

	}

}
