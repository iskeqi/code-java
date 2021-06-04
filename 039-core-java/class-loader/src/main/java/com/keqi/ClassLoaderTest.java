package com.keqi;

/**
 * @author keqi
 */
public class ClassLoaderTest {

	sun.misc.Launcher launcher;
	// sun.misc.Launcher.ExtClassLoader
	// sun.misc.Launcher.AppClassLoader 自己编写的 Java 代码就是这个类加载器加载出来的
	ClassLoader classLoader;

	public static void main(String[] args) throws Throwable {
		test5();
	}

	public static void test5() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		// 对于一个接口，有多个实现类时，可以通过这种可配置的方式，通过反射的方式去创建对象
		Class<?> clazz = Class.forName("com.keqi.ClassLoaderTest");

		Class<?> aClass = Class.forName("com.keqi.ClassLoaderTest", true, ClassLoader.getSystemClassLoader());
		System.out.println(clazz == aClass);
		ClassLoaderTest classLoaderTest = (ClassLoaderTest) clazz.newInstance();
		System.out.println(classLoaderTest.toString());
	}

	public static void test4() {
		// Class.forName() 和 ClassLoader 的 loadClass 方法都能够加载字节码文件，并创建 Class 对象
		// 区别在与前者会执行静态代码块的内容，后者不会
	}

	public static void test3() throws ClassNotFoundException {
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

		// 使用 sun.misc.Launcher.AppClassLoader 加载 java.util.ArrayList 字节码
		Class<?> arrayListClass = systemClassLoader.loadClass("java.util.ArrayList");

		ClassLoader classLoader = arrayListClass.getClassLoader();
		// 基于双亲委派模型，这里实际上是使用的 bootstrapClassLoader 来加载的，所以输出是 null
		System.out.println(classLoader);
	}

	public static void test2() {
		// 系统默认的 ClassLoader 就是这个 sun.misc.Launcher.AppClassLoader
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader.getClass().getCanonicalName());
	}

	public static void test1() {
		ClassLoader appClassLoader = ClassLoaderTest.class.getClassLoader();
		System.out.println(appClassLoader.getClass().getCanonicalName());

		ClassLoader extClassLoader = appClassLoader.getParent();
		System.out.println(extClassLoader.getClass().getCanonicalName());

		// Bootstrap ClassLoader 不是由Java实现的，没有对应的类，所以这里获取到的就是 null，但它是真实存在的
		ClassLoader bootstrapClassLoader = extClassLoader.getParent();


		System.out.println(bootstrapClassLoader.getParent() == null);
	}
}
