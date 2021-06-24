package com.keqi.util;

import java.util.*;

public class CollectionsTest {

	/*
		类 Collections 以静态方法的方式提供了很多通用算法和功能，可以大致分为两类

		对容器对象进行操作
			查找和替换
			排序和调整顺序
			添加和修改

		返回一个容器对象
			适配器：将其他类型的数据转换为容器对象
			装饰器：修饰一个给定容器接口对象，增加某种性质
	 */


	public static void main(String[] args) {
		// 这个方法非常适合用来返回一个空的集合，避免NPE问题
		List emptyList = Collections.emptyList();

		System.out.println(emptyList.size());

		List emptyList1 = Collections.EMPTY_LIST;
		List<Object> objects = Collections.emptyList();


		// 构造一个只有一个 value 的集合
		Set<String> set = Collections.singleton("set");
		List<String> list = Collections.singletonList("list");
		Map<String, String> map = Collections.singletonMap("key", "value");

		// 返回一个空的集合
		List emptyList2 = Collections.EMPTY_LIST;
		Set emptySet = Collections.EMPTY_SET;
		Map emptyMap = Collections.EMPTY_MAP;
	}

	public void test1() {
		// 查找和替换

		// 二分查找
		// Collections.binarySearch()
		// 查找最大值
		// Collections.max()
		// 查找最小值
		// Collections.min()
		// 替换
		// Collections.replaceAll()

	}

	public void test2() {
		// 排序和调整顺序
		// Collections.sort();
		// Collections.swap();
		// Collections.reverse();
		// Collections.shuffle();

	}

	public void test3() {
		// 添加和修改
		// Collections.addAll()
		// Collections.fill();
		// Collections.copy();
	}

	public void test4() {
		/*
			适配器
				空容器方法：返回空的容器对象
				单一容器对象：返回仅有一个容器的对象
		 */
		// Collections.EMPTY_LIST
		// Collections.singletonList()
	}

	public void test5() {
		/*
			装饰器
		 */
		// Collections.unmodifiableList()
	}
}
