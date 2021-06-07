package com.keqi.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author keqi
 */
public class StreamTest {
	
	public static void main(String[] args) {
		StreamTest streamTest = new StreamTest();
		streamTest.test1();
	}
	
	public void test1() {
		// 获取 stream 的几种方法
		// 1、实现了 Collection 接口的类，可以通过 stream() 方法获取 Stream 对象
		Collection<String> collection = null;
		List<String> list = new ArrayList<>();
		Stream<String> stream = list.stream();
		System.out.println(stream);
		
		// 2、Arrays 类的 stream() 方法
		String[] arr = new String[]{"a", "b", "c", "d"};
		Stream<String> stringStream = Arrays.stream(arr);
		
		// 3、Stream 类的静态方法 of()
		Stream<String> stream1 = Stream.of("a", "b", "c", "d");
	}
	
	
	public void test2() {
		// 中间操作
		Stream<String> stream = Arrays.asList("a", "b", "c", "d").stream();
		
		// Stream<String> distinct = stream.distinct();
		
		// Stream<String> sorted = stream.sorted();
	}
	
	
}
