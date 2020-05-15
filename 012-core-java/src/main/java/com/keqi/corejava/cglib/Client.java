package com.keqi.corejava.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟消费者
 */
public class Client {

	public static void main(String[] args) {
		// 通过动态代理的方式，即字节码的方式生成代理对象，然后放到IOC容器中去使用，原有的目标对象，已经完成了历史使命了，
		// 根本就没有资格进入IOC工厂，已经完成了它的历史使命了好么。韭菜被榨干了，就可以抛弃了哦

		// 目标对象
		Producer producer = new Producer();
		// 通过代理技术生成的代理对象
		Object o = Enhancer.create(producer.getClass(), new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

				// Spring 中的 AOP
				Object invoke = method.invoke(producer, objects);


				return invoke;
			}
		});
	}
}
