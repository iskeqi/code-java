package com.keqi.springbootredispubsub.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author keqi
 */
@RestController
@RequestMapping("/iot")
public class IotController {

	// 注入Redis消息监听容器对象
	@Autowired
	RedisMessageListenerContainer redisMessageListenerContainer;


	@PostMapping(value = "/unLock")
	public boolean unLock(@RequestParam String thingName,
	                      @RequestParam String requestId)
			throws InterruptedException, ExecutionException, TimeoutException {

		//此处实现异步消息调用处理....

		//生成监听频道Key
		String key = "IOT_" + thingName + "_" + requestId;
		//创建监听Topic
		ChannelTopic channelTopic = new ChannelTopic(key);

		//创建消息任务对象
		IotMessageTask iotMessageTask = new IotMessageTask();
		try {
			redisMessageListenerContainer.addMessageListener(iotMessageTask, channelTopic);
			System.out.println("订阅了： " + key);

			// 通过异步线程完成一系列同步操作

			// 进入同步阻塞等待，超时时间设置为60秒(之所以能够阻塞，是因为调用了CompletableFuture对象的get()方法)
			// Message message = (Message) iotMessageTask.getIotMessageFuture().get(60000, TimeUnit.MILLISECONDS);
			Message message = (Message) iotMessageTask.getIotMessageFuture().get();
			System.out.println("线程阻塞完毕，收到的响应结果： " + message.toString());
		} finally {
			// 销毁消息监听对象
			redisMessageListenerContainer.removeMessageListener(iotMessageTask);
		}
		return true;
	}
}
