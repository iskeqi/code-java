package com.keqi;

/**
 * @author keqi
 */
public class MyClassLoader extends ClassLoader {

	/*
		自定义类加载器后，可以从不同的目标源获取加载字节码文件，默认的类加载器只能从类路径下加载
		不再局限于本地类路径，而可以通过网络IO获取到各种不同的数据源下的数据

		默认的类加载器只能加载同一个类一次，但是同一个类是可以被多个不同的类加载器进行加载的。
		这样就可以实现以下两个功能：
			1、实现隔离：通过不同的类加载器加载同一份字节码文件，就可以生成多个不同的 Class 对象。Tomcat 就是利用了这个特性实现了隔离不同 web应用的功能
			2、实现热部署：使用同一个ClassLoader，类只会被加载一次，加载后，即使class文件已经变了，再次加载，得到的也还是原来的Class对象。
			但是如果使用一个新的类加载器对象，再去加载同一个类，就能够得到新的 Class 对象，这样就能够实现动态更新。
	 */






















	@Override
	protected Class<?> findClass(String name) {
		// 通过重写 ClassLoader 类的 findClass 方法，能够实现自定义加载字节码，并创建Class对象
		// 通过文件、网络 io 能够得到字节数组
		byte[] bytes = new byte[10];
		return defineClass(name, bytes, 0, bytes.length);
	}
}
