package com.keqi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 测试 java.util.Arrays 类
 */
public class ArraysTest {

	/*
		Arrays 类专门用来操作数组的，提供的方法主要可以分为以下几类：
			排序：
				public static void sort(int[] a)
				public static void parallelSort(int[] a)

			查找：

				public static int binarySearch(int[] a, int key)

			其它：
				public static IntStream stream(int[] array)
	 */

	@Test
	public void testSort() {
		int[] arr = {5,2,6,7,9,4,8,0,0};
		// 默认升序排序（用的快排）
		Arrays.sort(arr);
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}

	@Test
	public void testParallelSort() {
		int[] arr = {5,2,6,7,9,4,8,0,0};
		// 并行排序，也就是分成多个线程排序，最后再综合排序后的结果
		Arrays.parallelSort(arr);
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}

	@Test
	public void testParallelPrefix() {
		int[] arr = {5,2,6,7,9,4,8,0,0};
		Arrays.sort(arr);
		// 通过二分查找的方式对一个有序序列进行查找
		int i = Arrays.binarySearch(arr, 8);
		System.out.println(i);
	}

	@Test
	public void testStream() {
		int[] arr = {5,2,6,7,9,4,8,0,0};
		// 把数组转成 Stream 接口类型的对象
		IntStream stream = Arrays.stream(arr);
		System.out.println(stream);
	}

	@Test
	public void testAsList() {
		int[] arr = {5,2,6,7,9,4,8,0,0};
		// 此方法使用的是 java.util.Arrays.ArrayList 类，有坑。
		// 因为它是一个很简陋版的实现，无法对内部数据进行修改
		List<Integer> integers = Arrays.asList(5, 2, 6, 7, 9, 4, 8, 0, 0);
		System.out.println(integers);

		// 建议替换成这种方式来创建顺序表
		ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(5,2,6,7,9,4,8,0,0));
		System.out.println(arrayList);
	}

}
