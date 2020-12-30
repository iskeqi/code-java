package com.keqi.io;

import java.io.File;
import java.io.IOException;

/**
 * 测试 java.io.File 类的使用
 */
public class FileTest {

	public static void main(String[] args) throws IOException {
		createFiles();
	}

	private static void createFiles() throws IOException {
		// 创建文件
		File file = new File("E:/KEQI/code-java/039-core-java/io/src/main/resources/c/a.txt");

		if (!file.exists()) {
			// 如果文件不存在，则创建此文件（如果当时的目录不存在时，就无法创建）
			// System.out.println(file.createNewFile());


			// mkdirs() 创建的是目录，不是文件，不是文件，不是文件
			System.out.println(file.mkdirs());
			System.out.println(file.isDirectory());// 输出为 true
			System.out.println(file.getAbsolutePath());
		}
	}

	private static void createTemporaryFiles() throws IOException {
		// 创建临时文件（这个其实在很多场景下是非常有效的，比如临时中间文件，直接让操作系统去删除即可，无需自己手动删除）

		File aa = File.createTempFile("aaa", ".txt");
		// 输出为：C:\Users\ADMINI~1\AppData\Local\Temp\aaa149156174615388002.txt
		System.out.println(aa.getAbsolutePath());
	}

	private static void asADirectory() throws IOException {
		String dirName = "E:/KEQI/code-java/039-core-java/io/src/main/resources";
		File path = new File(dirName);

		//=========== java.io.File 类作为目录时的操作 ===========//

		System.out.println("file.isDirectory(): " + path.isDirectory());

		System.out.println("file.isFile(): " + path.isFile());

		System.out.println("file.getPath(): " + path.getPath());

		System.out.println("file.exists(): " + path.exists());

		System.out.println("file.getCanonicalPath(): " + path.getCanonicalPath());

		System.out.println("file.getAbsolutePath(): " + path.getAbsolutePath());

		System.out.println("file.getParent(): " + path.getParent());

		System.out.println("file.length(): " + path.length());
	}

	private static void asAFile() throws IOException {
		// 输出为：E:\KEQI\code-java\039-core-java
		System.out.println(System.getProperty("user.dir"));
		String dir = "E:/KEQI/code-java/039-core-java/io/src/main/resources";
		String name = "Snipaste_2020-12-30_16-37-50.png";

		//=========== java.io.File 类作为文件时的操作 ===========//

		// 无论是 windows 还是 linux ，路径分隔符一律使用符号 "/" 是没有问题的
		System.out.println(File.separator); // 输出为 \
		System.out.println(File.pathSeparator); // 输出为 ;


		// File file = new File(dir, name);
		File file = new File(dir + File.separator + name);

		System.out.println("file.getName(): " + file.getName());

		System.out.println("file.isAbsolute(): " + file.isAbsolute());

		System.out.println("file.getPath(): " + file.getPath());

		System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());

		System.out.println("file.getCanonicalPath(): " + file.getCanonicalPath());

		System.out.println("file.getParent(): " + file.getParent());

		System.out.println("file.isFile(): " + file.isFile());

		System.out.println("file.isDirectory(): " + file.isDirectory());

		// 如果 File 对象表示的是一个文件的话，此方法可以获取文件的大小（单位是 byte）
		System.out.println("file.length(): " + file.length());
	}
}
