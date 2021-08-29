package com.keqi.c1;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestByteBufferExam {

	public static void main(String[] args) {

		// 实际网络开发过程中，肯定会遇到粘包和半包的问题，如果自己使用NIO编程，就需要自己处理
		// 使用 netty 的话，它就帮你处理玩了

		ByteBuffer source = ByteBuffer.allocate(32);
		source.put("Hello,world\nI'm zhangsan\nHo".getBytes(StandardCharsets.UTF_8));
		split(source);
		source.put("w are you?\n".getBytes(StandardCharsets.UTF_8));
		split(source);
	}

	private static void split(ByteBuffer source) {
		// 切换到读模式
		source.flip();
		for (int i = 0; i < source.limit(); i++) {
			byte b = source.get(i);
			if ('\n' == b) {
				int length = i + 1 - source.position();
				ByteBuffer allocate = ByteBuffer.allocate(length);
				for (int j = 0; j < length; j++) {
					allocate.put(source.get());
				}

			}
		}

		// 切换到写模式
		source.compact();
	}
}
