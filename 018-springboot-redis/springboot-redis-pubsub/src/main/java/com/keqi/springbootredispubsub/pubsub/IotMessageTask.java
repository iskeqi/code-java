package com.keqi.springbootredispubsub.pubsub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.concurrent.CompletableFuture;

/**
 * @author keqi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IotMessageTask implements MessageListener {

	//声明线程异步阻塞对象(JDK 1.8新提供Api)
	private CompletableFuture<Message> iotMessageFuture = new CompletableFuture<>();

	/**
	 * Callback for processing received objects through Redis.
	 *
	 * @param message message must not be {@literal null}.
	 * @param pattern pattern matching the channel (if specified) - can be {@literal null}.
	 */
	@Override
	public void onMessage(Message message, byte[] pattern) {
		// 线程阻塞完成(调用了CompletableFuture对象的complete()方法来结束这个阻塞)
		this.iotMessageFuture.complete(message);
	}


}
