package com.keqi;

import org.junit.Test;

/**
 * 测试 java.util.Math 类
 */
public class MathTest {

	/*
		java.util.Math类是数学相关的工具类，里面提供了大量的静态方法，完成与数学运算相关的操作。
			public static double random()


	 */

	@Test
	public void test1() {
		int random = (int) (Math.random() * (7 - 5) + 5);
		System.out.println(random); // [5,7]
	}
}
