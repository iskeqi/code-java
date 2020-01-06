package com.keqi.springbootdesignpattern.pattern.creational.singleton;

/**
 * 单例
 */
public class SingletonPatternDemo {

	/*
		单例的意思就是，一个类只生成一个对象。至于单例的实现方式，有很多种，比如：

			懒汉式，线程不安全
			懒汉式，线程安全
			饿汉式
			双检锁/双重校验锁
			登记式/静态内部类
			枚举
			SpirngIOC方式

		如果是Spring程序直接使用@Component注解就可以了，不是的话推荐使用枚举方式。

		更多的实现代码，就不写在这里了，直接参考菜鸟教程的设计模式就可以了

	 */


	public static void main(String[] args) {

		//不合法的构造函数
		//编译时错误：构造函数 SingleObject() 是不可见的
		//SingleObject object = new SingleObject();

		//获取唯一可用的对象
		SingleObject object = SingleObject.getInstance();

		//显示消息
		object.showMessage();
	}
}
