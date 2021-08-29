package com.keqi.c1;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestByteBuffer {

	public static void main(String[] args) {
		String data = "D:\\KEQI\\MyCode\\code-java\\059-netty\\netty-day01\\data.txt";
		// FileChannel
		// 1. 通过输入输出流 2、通过 RandomAccessFile
		try (FileChannel channel = new FileInputStream(data).getChannel()) {
			// 需要有一个缓冲区来暂存字节内容
			ByteBuffer buffer = ByteBuffer.allocate(10);
			while (true) {
				// 通过 channel 读取数据
				int len = channel.read(buffer);
				log.debug("读取到的字节数 {}", len);
				if (len == -1) {
					return;
				}

				// 打印 buffer 中的内容
				buffer.flip(); // 切换到 buffer 的读模式
				while (buffer.hasRemaining()) { // 检查是否还有剩余的未读的数据
					byte b = buffer.get();
					log.debug("实际字节 {}", (char) b);
				}

				// 切换到写模式（直接清空数组内容）
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
