package com.keqi;

import org.junit.Test;

/**
 * 测试 java.lang.System 类
 */
public class SystemTest {

	/*
		java.lang.System 类中有一些系统相关的方法，用的还是比较频繁的：

			// 获取系统当前时间的时间戳表示形式
			public static native long currentTimeMillis();

			// 开启 GC
			public static void gc()

			// 复制数组
			public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);

	 */

	@Test
	public void test1() {
		long l = System.currentTimeMillis();
	}

	@Test
	public void test2() {
		System.gc();
	}

	@Test
	public void test3() {
		int[] src = {1,2,3,4,5,6,7,8,9};
		int[] dest = {0,0,0,0,0,0,0,0,0};
		// 搞不清楚，为啥会在这个类里面设计一个数组复制的方法，可能是脑子抽了吧
		System.arraycopy(src, 0, dest, 0, src.length);
		for (int i : dest) {
			System.out.print(i + " ");
		}
	}
}
