package com.keqi.cache;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.thread.ThreadUtil;

/**
 * 测试 TimeCache 类的使用（本质上是开启了线程定时去轮训，再按照指定规则去删除掉缓存中的数据）
 */
public class TimedCacheTest {

	public static void main(String[] args) {
		// 指定过期时间为一小时
		TimedCache<String, String> objects = CacheUtil.newTimedCache(360);
		// 启动定时任务，每一分钟检查一次过期时间
		objects.schedulePrune(3600);

		objects.put("token", "user info");
		System.out.println(objects.get("token"));

		ThreadUtil.sleep(9200);
		System.out.println(objects.get("token"));
	}
}
