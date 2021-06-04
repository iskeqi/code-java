package com.keqi;

import java.io.File;
import java.io.IOException;

/**
 * @author keqi
 */
public class FunctionReferenceTest {

	public static void main(String[] args) {

	}

	/*
		如果 lambda 表达式代码块中的代码数量过多时，可以单独提取出来作为方法，然后将方法作为参数传递进去
			仅要求该方法的方法签名和函数式接口的相同（如果代码块中需要访问其它变量，那么就无法改成方法引用的方式了）

		用法：

			实例对象::实例方法名

			实例对象::静态方法名
			类::静态方法名
	 */

	public void test1(String suffix) throws IOException {
		File f = new File(".");
		// 把函数代码作为参数进行传递，代码过多时，可以单独抽象出来一个方法，然后进行传递，代码可读性会更高
		File[] files = f.listFiles(this::test);
		for (File file : files) {
			System.out.println(file.getCanonicalPath());
		}
	}

	public boolean test(File dir, String name) {
		try {
			System.out.println(dir.getCanonicalPath());
			System.out.println(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}
