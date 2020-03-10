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

	@Test
	public void testEnumName() {
		String ALL = "ALL";

		// 枚举类是重写了toString() 方法的
		System.out.println(SampleTypeEnum.ALL.toString());
		// 通过枚举类的name()方法，也是可以直接获取到对象的名字的那个字符串的哦
		System.out.println(SampleTypeEnum.ALL.name());

		System.out.println(SampleTypeEnum.ALL.name().equals(ALL)); // 输出为true

		System.out.println(SampleTypeEnum.ALL.toString().equals(ALL)); // 输出为true
	}

}
