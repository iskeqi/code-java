package com.keqi.springbootredispubsub.pubsub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * 下面两个配置必须要自己添加进去，因为默认没有配置他们
 * @author keqi
 */
@Configuration
public class MyRedisConfig {


	/** 声明一个RedisMessageListenerContainer对象 */
	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory connectionFactory){
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		return container;
	}

	/**
	 * 绑定消息监听者和接收监听的方法,必须要注入这个适配器，不然会报错
	 */
	@Bean
	public MessageListenerAdapter listenerAdapter() {
		return new MessageListenerAdapter();
	}

}