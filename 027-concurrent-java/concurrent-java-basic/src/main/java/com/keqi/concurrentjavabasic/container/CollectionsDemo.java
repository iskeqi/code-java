package com.keqi.concurrentjavabasic.container;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsDemo {

	public static void main(String[] args) {
		Hashtable<String, String> hashtable = new Hashtable<>();
		hashtable.put("a","a");

		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("a", "a");
		String a = concurrentHashMap.get("a");

		// 一般的业务开发中的确用的少，但是面试就喜欢问，毕竟面试造火箭，工作拧螺丝钉

	}
}
