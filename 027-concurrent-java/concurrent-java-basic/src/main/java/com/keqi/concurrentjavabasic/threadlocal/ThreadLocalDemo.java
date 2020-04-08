package com.keqi.concurrentjavabasic.threadlocal;

import java.util.Map;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		// 这里的泛型，其实就是指定了ThreadLocalMap对象的value的类型
		ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

	}


}
