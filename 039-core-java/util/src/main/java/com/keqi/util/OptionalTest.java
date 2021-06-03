package com.keqi.util;

import java.util.Optional;

/**
 * @author keqi
 */
public class OptionalTest {
	public static void main(String[] args) {
		Optional<String> optional = test();
		
		// 可以指定如果为 null 时的返回值
		String a = optional.orElse("a");
		System.out.println(a);
		
		// 可以指定一个实现了 Supplier 接口的对象
		String s = optional.orElseGet(() -> "b");
		System.out.println(s);
		
		// 可以直接抛出异常
		String r = optional.orElseThrow(() -> new RuntimeException("username 不存在"));
		System.out.println(r);
	}
	
	private static Optional<String> test() {
		return Optional.ofNullable(Math.random() > 0.5 ? "jack" : null);
	}
}
