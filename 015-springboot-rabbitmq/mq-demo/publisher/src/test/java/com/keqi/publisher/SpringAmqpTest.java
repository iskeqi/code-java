package com.keqi.publisher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@RabbitListener
	@Test
	public void testSendMessage2SimpleQueue() {
		String queueName = "simple.queue";
		String message = "hello, spring amqp!";
		rabbitTemplate.convertAndSend(queueName, message);

		rabbitTemplate.send(new Message(message.getBytes(StandardCharsets.UTF_8)));

		// exchange 和 queue 应该由 publisher 去声明，而不是消费者
	}
}
