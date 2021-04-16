package com.keqi.util;

/**
 * Main 包装类
 *
 * @author keqi
 */
public class BaoZhuangLeiTest {

	public static void main(String[] args) {
		// Integer integer = 12;
		// 自动拆箱和装箱只是一个 Java 编译器中的概念，实际上 Java 编译器最终还是通过 valueOf() 和 xxxValue() 方法进行装箱和拆箱的

		// 而且，对于常见的数据，包装类中都使用了静态类和静态字段去进行缓存，避免重复创建对象
		// 把常用对象通过 static 的方式进行共享，这种设计模式就叫做享元设计模式

		// Float l = 12.312F;

		System.out.println(Integer.toBinaryString(1000));
		System.out.println(Integer.toHexString(1000));
		// System.out.println(Integer.toString(1, 10));
		System.out.println(Integer.parseInt("123", 10));
		System.out.println(Integer.parseInt("123", 16));
		System.out.println(Integer.parseInt("123", 20));

		// 包装类都是不可变的，不可变的，不可变的
		Boolean b;
		Character character;
		CharSequence charSequence;

		String s;
	}
}
