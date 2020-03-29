package com.keqi.hutool.core;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * 测试cn.hutool.core.thread.ThreadUtil类的使用
 */
public class ThreadUtilTest {

	@Test
	public void test1() {
		System.out.println("CurrentThread -> " + Thread.currentThread());
		// 使用execute()通过默认的线程池来开启一个新的线程
		ThreadUtil.execute(
				() -> System.out.println("ThreadUtil -> " + Thread.currentThread())
		);
	}

	/**
	 * 所谓延迟任务，其实就是通过 sleep() 来实现的哦，
	 */
	@Test
	public void test2() {
		System.out.println("线程开始执行啦: " + LocalDateTime.now());
		ThreadUtil.sleep(1L, TimeUnit.MINUTES);
		System.out.println("线程结束啦:" + LocalDateTime.now());
	}
}
