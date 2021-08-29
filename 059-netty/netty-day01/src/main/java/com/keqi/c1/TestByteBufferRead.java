package com.keqi.c1;

import java.nio.ByteBuffer;

public class TestByteBufferRead {

	/*
		针对于这个缓存了网络数据的数组，有很多操作方法，需要好好熟悉下

	 */


	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(10);

		buffer.put(new byte[]{'a','b','c','d'});
		buffer.flip();

		// 从头开始读
		byte[] a = new byte[4];
		buffer.get(a);
		System.out.println(new String(a));

		// 从头读取（重置 position 为 0 ）
		buffer.rewind();

		byte[] b = new byte[4];
		buffer.get(b);
		System.out.println(new String(b));

		// mark & reset
		// mark 做一个标记，记录 position 位置，reset 是将 position 重置到 mark 的位置


		buffer.rewind();
		byte b1 = buffer.get();

		buffer.mark();
		System.out.println(buffer.position());

		byte b2 = buffer.get();
		System.out.println(String.valueOf(b1) + " " + String.valueOf(b2));

		buffer.reset();
		System.out.println(buffer.position());

		byte b3 = buffer.get();
		System.out.println(String.valueOf(b2) + " " + String.valueOf(b3));



	}
}
