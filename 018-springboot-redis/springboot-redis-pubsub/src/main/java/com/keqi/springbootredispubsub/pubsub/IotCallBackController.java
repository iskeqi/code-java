package com.keqi.springbootredispubsub.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author keqi
 */
@RestController
@RequestMapping("/iot")
public class IotCallBackController {

	//引入Redis客户端操作对象
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@PostMapping("/unLockCallBack")
	public boolean unLockCallBack(@RequestParam String thingName,
	                              @RequestParam String requestId) {
		// 生成监听频道Key
		String key = "IOT_" + thingName + "_" + requestId;
		//模拟实现消息回调
		// 发送一个JSON字符串作为发布消息结果
		stringRedisTemplate.convertAndSend(key, "这是回调结果");
		return true;
	}
}
