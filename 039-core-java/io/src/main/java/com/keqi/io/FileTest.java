package com.keqi.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * 测试 java.io.File 类的使用
 * <p>
 * File 类的操作可以分为三类：
 * 1、文件元数据
 * 2、文件操作
 * 3、目录操作
 */
public class FileTest {

	public static void main(String[] args) throws IOException {
		createTemporaryFiles();
	}

	/**
	 * 文件元数据
	 *
	 * @throws IOException
	 */
	private static void fileMetaData() throws IOException {
		String dir = "D:\\KEQI\\MyCode\\code-java\\039-core-java\\io\\src\\main\\resources";
		String name = "Snipaste_2020-12-30_16-37-50.png";

		// 推荐使用此种构造函数，因为可以将文件的路径和文件名称区分出来，然后当
		// 文件路径不存在时，可以创建相关的文件路径
		File file = new File(dir, name);

		System.out.println(file.getName());

		System.out.println(file.isAbsolute());

		System.out.println(file.getPath());

		System.out.println(file.getAbsolutePath());

		System.out.println(file.getCanonicalPath());

		System.out.println(file.getParent());

		System.out.println(file.exists());

		System.out.println(file.isDirectory());

		System.out.println(file.isFile());

		System.out.println(file.length());

		System.out.println(new Date(file.lastModified()));

		System.out.println(file.isHidden());

		System.out.println(file.canExecute());

		System.out.println(file.canRead());

		System.out.println(file.canWrite());
	}

	private static void createFiles() throws IOException {
		// 创建文件
		File file = new File("E:/KEQI/code-java/039-core-java/io/src/main/resources/c");

		if (!file.exists()) {
			// 如果文件不存在，则创建此文件（如果当时的目录不存在时，就无法创建）
			// System.out.println(file.createNewFile());


			// mkdirs() 创建的是目录，不是文件，不是文件，不是文件
			System.out.println(file.mkdirs());
			System.out.println(file.isDirectory());// 输出为 true
			System.out.println(file.getAbsolutePath());

			file = new File(file.getAbsolutePath(), "a.txt");
			System.out.println(file.createNewFile());
		}
	}

	private static void createTemporaryFiles() throws IOException {
		// 创建临时文件（这个其实在很多场景下是非常有效的，比如临时中间文件，直接让操作系统去删除即可，无需自己手动删除）

		File aa = File.createTempFile("aaa", ".txt");
		// 输出为：C:\Users\keqi\AppData\Local\Temp\aaa4106415554052959356.txt
		System.out.println(aa.getAbsolutePath());

		String dirName = "D:\\KEQI\\MyCode\\code-java\\039-core-java\\io\\src\\main\\resources";
		File bbb = File.createTempFile("bbb", ".txt", new File(dirName));
		// D:\KEQI\MyCode\code-java\039-core-java\io\src\main\resources\bbb6492646535381023082.txt
		// 这种指定了目录的方式，就没有意义了，和普通创建一个文件没有任何区别（不推荐使用）
		System.out.println(bbb.getAbsolutePath());
	}

	private static void asADirectory() throws IOException {
		String dirName = "D:\\KEQI\\MyCode\\code-java\\039-core-java\\io\\src\\main\\resources";
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

		// 因为目录已经存在，所以此处返回值的是 false
		System.out.println(path.mkdirs());

		// 因为目录已经存在，所以此处返回值的是 false
		System.out.println(path.mkdir());

		System.out.println(Arrays.toString(path.list()));

		System.out.println(Arrays.toString(path.list((dir, name) -> {
			// 只返回后缀为 ".png" 的文件
			return name.endsWith(".png");
		})));
	}

	private static void asAFile() throws IOException {
		// 输出为：E:\KEQI\code-java\039-core-java
		System.out.println(System.getProperty("user.dir"));
		String dir = "D:\\KEQI\\MyCode\\code-java\\039-core-java\\io\\src\\main\\resources";
		String name = "Snipaste_2020-12-30_16-37-50.png";

		//=========== java.io.File 类作为文件时的操作 ===========//

		// 无论是 windows 还是 linux ，路径分隔符一律使用符号 "/" 是没有问题的
		System.out.println(File.separator); // 输出为 \
		System.out.println(File.pathSeparator); // 输出为 ;


		// File file = new File(dir, name);
		File file = new File(dir, name);

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

		// System.out.println(file.delete());

		// 对于文件重命名，其实此处不仅仅可以改动文件名称，而是可以改动文件所在的目录
		System.out.println(file.renameTo(new File(dir, "Snipaste_2020-12-30_16-37-50.png")));
	}
}
