package com.keqi.springbootredissortedsets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * @author keqi
 */
@RestController
public class DemoController {

	private static final String ZSETKEY = "zsetkey";

	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	@GetMapping("/test1")
	public void test1(@RequestParam Integer minute) {
		ZSetOperations<String, String> zSetOperations = stringRedisTemplate.opsForZSet();

		for (int i = 0; i < minute; i++) {
			zSetOperations.add(ZSETKEY, UUID.randomUUID().toString(), System.currentTimeMillis());
		}
		// 插入数据到 zsetkey 中(模拟新增了延时任务)
		//zSetOperations.add(ZSETKEY, UUID.randomUUID().toString(), System.currentTimeMillis() + (minute * 3600));
	}

	@GetMapping("/test2")
	public void test2() {
		ZSetOperations<String, String> zSetOperations = stringRedisTemplate.opsForZSet();

		// 从 zsetkey 中查询数据(模拟定时任务获取当前待执行的定时任务)

		long currentTimeMillis = System.currentTimeMillis();
		// 内存分页逻辑
		Long count = zSetOperations.count(ZSETKEY, 0, currentTimeMillis);

		Set<String> sets = zSetOperations.rangeByScore(ZSETKEY, 0, currentTimeMillis);
		LocalDateTime startTime = LocalDateTime.now();
		zSetOperations.removeRangeByScore(ZSETKEY, 0, currentTimeMillis);
		/*for (String value : sets) {
			// 挨个将待执行的任务添加到线程池任务队列中，等待执行
			//System.out.println(value);
			//zSetOperations.remove(ZSETKEY, value);
		}*/
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println(startTime + "-->" + endTime);
		/*for (int i = 1; i <= (count / 500) + 1; i++) {
			Set<String> zsetkey = zSetOperations.rangeByScore(ZSETKEY, 0, currentTimeMillis, ((i - 1) * 500L), 500);*/
			/*for (String s : zsetkey) {
				// 挨个将待执行的任务添加到线程池任务队列中，等待执行
				System.out.println(s);
			}
		}*/

		// 数据量小的情况下，每 5 秒钟执行一次，取出当前 5 秒内需要执行的全部数据，依次添加到任务队列中，并删除当前 key 。完全能保证 5 秒内完成
		// 绝大部分情况下，以上方式都能够满足需求
		// 10 万条数据，也才耗费不到8秒钟
		// 6000 条数据，才不到 1 秒钟
		// 使用 zrangebyscore 取出指定范围内的所有数据，再使用 zremrangebyscore 删除指定分数范围内的所有数据，非常快
		// 上面速度慢是以为网络操作次数太多导致的

		// 减少网络操作，速度立马就能提升
	}
}
