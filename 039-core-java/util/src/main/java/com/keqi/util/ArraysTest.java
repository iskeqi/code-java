package com.keqi.util;

import java.util.Arrays;

/**
 * @author keqi
 */
public class ArraysTest {

	public static void main(String[] args) {
		// Arrays.copyOf() 这个方法在 ArrayList 中是一个很核心的方法
		// 此方法的作用是复制原来的数组中的数据到一个指定长度的新的数组中，并将新数组作为方法的返回值进行返回
		String[] strs = {"a", "b", "c", "d"};
		System.out.println(Arrays.copyOf(strs, 10).length);


		//  Arrays.copyOf() 方法的底层实现本质上是调用了 System.arraycopy() 方法，而这个方法则是一个 native 方法，并不是采用的
		// java 代码实现的
		String[] newStrs = new String[100];
		System.arraycopy(strs, 0, newStrs, 0, strs.length);
		System.out.println(newStrs.length);
	}
}
