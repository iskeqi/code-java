package com.keqi.c1;

import java.nio.ByteBuffer;

public class TestByteBufferReadWrite {

	/*
		ByteBuffer 抽象类有3个重要方法：
			flip() 切换到读模式

			clear() 清空数组的内容，切换到读模式（position 切换为 0 ）

			compact() 把未读取的数据放到数组最前面，然后从最新的位置开始进行写入（position 切换为数组当前大小的值 ）


	 */



	public static void main(String[] args) {

		ByteBuffer buffer = ByteBuffer.allocate(10);

		buffer.put((byte) 0x61); // 插入 a

		buffer.put(new byte[] {'b','c','d'});

		// 切换到读模式，
		buffer.flip();
		System.out.println(buffer.get(0));

		// 切换到写模式，把未读取的内容移到数组最前面
		buffer.compact();

		//
		System.out.println(buffer.get(0)); // 输出的应该是 0 ，而不是 'a'（97）
	}
}
