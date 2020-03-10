package com.keqi.corejava.enumtest;

import org.junit.Test;

public class EnumTest {

	@Test
	public void test() {
		System.out.println(DataSourceTypeEnum.MASTER);

	}

	@Test
	public void testEnumEquals() {
		// 这样比较肯定是不等的，一个是枚举对象一个知识字符串
		System.out.println(SampleTypeEnum.ALL.equals("ALL")); // 输出为false

		// 如果枚举是没有值的呢？
		System.out.println(DataSourceTypeEnum.MASTER.equals("MASTER")); // 输出仍然为false
	}

}
