package com.keqi.c1;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {

	public static void main(String[] args) {
		System.out.println(ByteBuffer.allocate(16).getClass());

		System.out.println(ByteBuffer.allocateDirect(16).getClass());

		/*
			class java.nio.HeapByteBuffer(使用的堆内存)
				读写效率低,收到 GC 的影响

			class java.nio.DirectByteBuffer（使用直接内存）
				读写效率高（少一次拷贝），使用的系统内存，不会收到GC的影响，分配的效率低
		 */

		// 写入数据
		// 通过 channel 的 read() 方法
		// 通过 ByteBuffer 的 put() 方法

		// 读数据
		// 通过 channel 的 write() 方法
		// 通过 ByteBuffer 的 get() 方法



	}
}
