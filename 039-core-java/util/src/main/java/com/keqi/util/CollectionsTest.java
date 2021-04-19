package com.keqi.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsTest {

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
}
