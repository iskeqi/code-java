package com.keqi.reflect;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IllegalAccessException {
		// 获取 java.lang.Class 对象的三种方法

		// 法一：仅知道对象时
/*		LocalDate today = LocalDate.now();
		Class<? extends LocalDate> localDateClazz = today.getClass();*/

		// 法二：仅知道类时
		Class<LocalDate> clazz = LocalDate.class;

		// 法三：仅知道类的字符串名称时
/*		try {
			Class<?> aClass = Class.forName("java.time.LocalDate");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/

		// 名称信息
		System.out.println(clazz.getName()); // Java 内部使用功能的真正名称
		System.out.println(clazz.getSimpleName()); // 简单名称
		System.out.println(clazz.getCanonicalName()); // 带上包名的全路径名称
		System.out.println(clazz.getPackage().getName()); // 获取包名称
		int modifiers1 = clazz.getModifiers(); // 获取类的修饰符
		Class<? super LocalDate> superclass = clazz.getSuperclass(); // 获取父类
		Class<?>[] interfaces = clazz.getInterfaces();

		// 对于类的操作，可能需要获取这个类的注解和父类、接口等信息


		// 获取类的字段对象 java.lang.reflect.Field
		System.out.println(Arrays.toString(clazz.getFields())); // 返回本类及其父类的所有 public 类型的字段(私有的不行)
		try {
			// 返回本类及其父类中指定名称的 public 类型的字段（私有的不行）
			System.out.println(clazz.getField("MIN").toString());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(clazz.getDeclaredFields())); // 返回本类中声明的所有字段，包括自己的 private 类型的字段
		try {
			// 返回本类中声明的指定名称的字段，肯定包括 private 的啦
			System.out.println(clazz.getDeclaredField("MIN").toString());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		// 拿到 Field 对象之后，获取字段信息以及访问字段信息等操作
		try {
			Field min = clazz.getDeclaredField("MIN");
			System.out.println(min.getName()); // 获取字段的名称
			System.out.println(min.isAccessible()); // 当前程序是否能够访问此字段
			min.setAccessible(true); // 如果上述方法无法访问，比如是 private 的，那么需要先调用此方法，然后才能使用对应的get/set方法
			Object o = min.get(LocalDate.now()); // 获取指定对象当前字段的值
			//min.set(LocalDate.now(), LocalDate.MAX); // 设置指定对象中该值为第二个参数的值

			// 通常需要用反射的时候，是知道它的字段名称，然后调用它的get/set方法

			int modifiers = min.getModifiers();
			String s = Modifier.toString(modifiers);
			Class<?> type = min.getType();
			// 获取这个字段上声明的所有注解
			Annotation[] declaredAnnotations = min.getDeclaredAnnotations();
			// 获取这个字段上指定的注解
			Resource annotation = min.getAnnotation(Resource.class);
			System.out.println(annotation);

			// 获取某个字段上面使用的注解，这也是一个非常常见的操作！！！
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		// 拿到 Method 对象之后，对于 Method 的各种操作
	}
}
