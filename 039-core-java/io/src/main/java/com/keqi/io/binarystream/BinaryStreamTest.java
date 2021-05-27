package com.keqi.io.binarystream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author keqi
 */
public class BinaryStreamTest {
	
	/*
		1、对于文本类型的小文件，直接使用二进制字节流通过字节数组的方式进行读取和写入即可
		2、对于文本类型的大文件，则需要通过
			BufferReader 的readLine() 方法一行一行的读取
			BufferWrite 的 write()/newLine() 方法通过追加的方式写入新内容到文件中
			
		对于二进制流、文本字符流的这几个类和相关方法都要狠狠的记住，但是在实际项目开发中，不建议使用
		原生的API，因为太繁琐了。建议直接使用 FileUtil 工具类，可以是 commons-io spirng hutool 都行
	 */
	
	public static void main(String[] args) {
		byte[] bytes = "this is a text\n".getBytes(StandardCharsets.UTF_8);
		
		File file = new File("D:/home/" + LocalDate.now() + "/" + UUID.randomUUID() + ".log");
		try {
			FileUtil.writeByteArrayToFile(file, bytes);
		} catch (IOException e) {
			// 文件写入失败
			e.printStackTrace();
		}
		
		try {
			FileUtil.writeByteArrayToFile(file, bytes);
		} catch (IOException e) {
			// 文件写入失败
			e.printStackTrace();
		}
		
		try {
			FileUtil.writeByteArrayToFile(file, bytes, true);
		} catch (IOException e) {
			// 文件写入失败
			e.printStackTrace();
		}
		
		try {
			byte[] byteArray = FileUtil.readFileToByteArray(file);
			System.out.println(new String(byteArray, StandardCharsets.UTF_8));
		} catch (IOException e) {
			// 文件读取失败
			e.printStackTrace();
		}
	}
	
	/**
	 * 将字节数组写入到文件中
	 * （可见要实现这个简单的需求，都需要写很多行代码，而且还要进行恶心的异常处理
	 * 实际开发过程中，建议直接使用对应的工具类
	 * ）
	 *
	 * @param bytes
	 */
	public void test1(byte[] bytes) {
		File dir = new File("D:/home/" + LocalDate.now());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, UUID.randomUUID() + ".log");
		
		OutputStream outputStream = null;
		try {
			outputStream = new BufferedOutputStream(new FileOutputStream(file));
			outputStream.write(bytes);
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
