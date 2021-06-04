package com.keqi;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author keqi
 */
public class LambdaTest {

	public static void main(String[] args) throws Throwable {
		LambdaTest lambdaTest = new LambdaTest();
	}

	public void test1(String suffix) throws IOException {
		File f = new File(".");
		File[] files = f.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(suffix);
			}
		});
		for (File file : files) {
			System.out.println(file.getCanonicalPath());
		}
	}

	public void test2() throws IOException {
		File f = new File(".");

		// 将匿名内部类改写为 lambda 的方式（使用 IDE 的智能提示功能就好）
		File[] files = f.listFiles((dir, name) -> name.endsWith(".iml"));

		for (File file : files) {
			System.out.println(file.getCanonicalPath());
		}
	}

	public void test3() throws IOException {
		File f = new File(".");

		// 将匿名内部类改写为 lambda 的方式（使用 IDE 的智能提示功能就好）
		File[] files = f.listFiles(pathname -> false);

		for (File file : files) {
			System.out.println(file.getCanonicalPath());
		}
	}

	public void test4(String suffix) throws IOException {
		File f = new File(".");

		// 与匿名内部类类似，lambda表达式也可以访问定义在主题代码外部的变量，但对于局部变量，
		// 它也只能方位 final 类型的变量，与匿名内部类的区别是，它不要求变量明确声明为final
		// 但要求变量事实上是 final 类型的
		// 如果是引用类型变量，同样要求不得更改

		// 这个原因与匿名内部类是一样的，java会将msg的值作为参数传递给lambda表达式，为lambda表达式
		// 建立一个副本，它的代码访问的是这个副本，而不是外部声明的msg变量。如果msg允许被修改，
		// 则程序员可能误以为lambda表达式可以读到修改后的值，从而引起混淆
		File[] files = f.listFiles((dir, name) -> name.endsWith(suffix));


		for (File file : files) {
			System.out.println(file.getCanonicalPath());
		}
	}

	/*
		匿名内部类的实现机制是：在内存中生成一个类，然后创建这个类的对象，再作为参数进行传递到具体的方法中。
		但是 lambda 表达式则不是采用这种机制，这种方式比创建类、再创建对象的方式性能更好。凡是用到匿名内部类的地方，都换成lambda表达式来写

	 */
}
