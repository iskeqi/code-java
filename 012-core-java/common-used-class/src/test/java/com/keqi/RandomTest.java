package com.keqi;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 测试 java.util.Random 类
 */
public class RandomTest {

	/*
		java.util.Random 类有一些生成随机数的方法：

			public int nextInt()

			public int nextInt(int bound)


		java.security.SecureRandom 类同 Random 类功能一致：

			public int nextInt()
	 */
	@Test
	public void test1() {
		Random random = new Random();
		System.out.println(random.nextInt());
	}

	@Test
	public void test2() {
		Random random = new Random();
		System.out.println(random.nextInt(10));
	}

	@Test
	public void test3() {
		SecureRandom secureRandom = new SecureRandom();
		System.out.println(secureRandom.nextInt());
	}
}
