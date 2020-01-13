package com.keqi.hutool.core;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

/**
 * 测试cn.hutool.core.thread.ThreadUtil类的使用
 */
public class ThreadUtilTest {

	@Test
	public void DateToLocalDateTime() {
		System.out.println("CurrentThread -> " + Thread.currentThread());
		// 使用execute()通过默认的线程池来开启一个新的线程
		ThreadUtil.execute(
				() -> System.out.println("ThreadUtil -> " + Thread.currentThread())
		);
	}
}
