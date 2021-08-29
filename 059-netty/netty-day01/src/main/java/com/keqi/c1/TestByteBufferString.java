package com.keqi.c1;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class TestByteBufferString {

	public static void main(String[] args) {
		// 将字符串转成 ByteBuffer

		// 方法一(此处方式写入时，仍然是写模式)
		byte[] bytes = "hello".getBytes();
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		buffer.put(bytes);

		System.out.println();

		// 方法二：这种方法更方便哦（这种方式写完数据后，就默认切换到读模式了）（推荐）
		ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");

		// 方法三：这种方式方便且直观（这种方式写完数据后，就默认切换到读模式了）
		ByteBuffer wrap = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));

		System.out.println(hello);

		// ByteBuffer 转换成字符串
		// 方法一：（推荐）
		String s = StandardCharsets.UTF_8.decode(hello).toString();


		String s1 = StandardCharsets.UTF_8.decode(wrap).toString();
		System.out.println();

		Charset.availableCharsets().keySet().forEach(System.out::println);
	}
}
