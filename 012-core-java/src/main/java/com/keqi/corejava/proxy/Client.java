package com.keqi.corejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟消费者
 */
public class Client {

	public static void main(String[] args) {
		// 原始方式：直接和目标对象进行交互
		Producer producer = new Producer();
		producer.saleProduct(1000);

		/**
		 * 动态代理：
		 *  特点：字节码随用随创建，随用随加载（也就是说不需要事先写好一个 .java 文件，而是在程序中动态的生成一个 .class 对象）
		 */
		IProducer proxyInstance = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
				producer.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// 根据条件判断是否需要进行代理，以及如何代理
						// 比如前置通知、后置通知、环绕通知、最终通知、异常抛出通知
						Object obj = null;
						try {
							// 前置通知
							obj = method.invoke(proxy, args);
							// 后置通知
						} catch (Exception e) {
							// 异常抛出通知
						} finally {
							// 最终通知
						}

						return obj;
					}
				});
	}
}
