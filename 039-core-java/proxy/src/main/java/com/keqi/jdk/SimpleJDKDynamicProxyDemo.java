package com.keqi.jdk;

import java.lang.reflect.*;

/**
 * @author keqi
 */
public class SimpleJDKDynamicProxyDemo {
	
	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		IService realService = new RealService();
		
		
		// 静态代理：先编写好对应的类代码，JVM加载对应的 .class 文件，并在内存中创建对应的 Class 对象，并创建实例对象
		// 动态代理：直接通过字节码的方式生成代理类的 Class 对象(!!!!)，再通过反射对象创建实例对象
		// 类代码在程序运行之后，创建对象之前，才确定。但不是通过代码生成的方式，而是通过字节码的方式生成 Class 对象
		
		// Proxy 类 和 CgLib 库提供的方法，仅仅是操作的API而已。真正的思想就是上面提的这种！！！
		
		// 所谓动态代理，指的是类代码是动态的，对象其实仅仅是类的一个实例而已
		
		// 通过字节码的方式生成了类代码而已啦，只是比通过字符串的方式生成源代码更高级一点啦
		/*IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.invoke(null, args);
			}
		});*/
		
		/*IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
				new Class<?>[] { IService.class }, new SimpleInvocationHandler(realService));*/
		
		Class<?> proxyClass = Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);
		Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
		IService proxyService = (IService) constructor.newInstance(new SimpleInvocationHandler(realService));
		
		
		/*
			JDK 动态代理的原理：
		
				1、通过字节码技术生成一个以 $Proxy 后面跟着数字的代理类，这个类继承了 Proxy 类，同时实现了目标类的接口
				2、生成的代理类实现了目标接口的所有方法，但是在调用这些方法的时候，全部转发给了 InvocationHandler 对象的 invoke() 方法
				3、也就是说，真正的核心点在于实现了 InvocationHandler 的类的代码是如何编写的。这也是个类呀，同样可以通过字节码技术生成代码咯
		 */
		
		/*
			动态代理的好处：
				实现一些通用的功能，而不需要进行静态代码编写，有效实现了解耦
		 */
		
		/*
			cglib 动态代理：
			
			JDK 动态代理，只能够支持实现了接口的类，来生成代理对象
			cglib 动态代理，则能够支持没有实现接口的类。它的使用 API 类似 JDK 。但是实现方式不同：
			
				1、它通过继承目标类来实现代理类
				2、每个 public 非 final 的方法都会被重写，然后同样转发给 MethodInterceptor 接口实现类的 intercept 方法
				
				
			cglib 动态代理的思想和 jdk 动态代理是一致的，API 使用也很相似。
			前者是通过继承的方式，可以对类进行代理，核心之处在 MethodInterceptor 实现类中
			后者则是通过实现接口的方式进行代理，只能对实现了接口的类进行代理，核心之处在 InvocationHandler 实现类中
		
			InvocationHandler 和 MethodInterceptor 内部的核心逻辑，就是切面类中编写的逻辑。
			到底要如何进行代理，当然是通过用户编写代码去指定的啦。最核心的一部分其实是给了用户去实现的
		
			两者互相补充。
		 */
		
		/*
			具体实现原理其实很简单，就是综合了IOC、反射、注解技术的一种综合运用
		
				1、通过反射获取到所有使用切面注解标记的切面类的各种方法，并存储起来（前置、后置、环绕、异常、最终）
				2、在IOC创建对象时，先创建目标对象，然后再根据切面类中的几个固定位置的方法，动态确定在哪个位置调用哪个方法
				3、这样通过不断嵌套的目标对象、代理对象的代理逻辑，得到一个最终的 代理对象，并最终存储到 IOC 容器中
				
				
			在这个过程里面根本就不存在代码生成，因为这整个过程都是通用的逻辑。包括最核心的 InvocationHandler 和 MethodInterceptor
			只有通过 JDK、cglib 的API得到的对象，才是真正通过字节码技术动态生成的 .class 反射对象，然后创建的实例对象
			
			最核心的 InvocationHandler 和 MethodInterceptor 的实现类也是实现就编写好的，已经这里面的代码其实
			是固定的，具体调用的不同，根据参数就能确定。
		 */
		
		
		//proxyService.sayHello();
	}
	
	static class SimpleInvocationHandler implements InvocationHandler {
		private final Object realObj;
		
		public SimpleInvocationHandler(Object realObj) {
			this.realObj = realObj;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println(proxy);
			System.out.println(this);
			System.out.println(this == proxy);
			System.out.println("===================");
			System.out.println("entering " + method.getName());
			Object result = method.invoke(realObj, args);
			System.out.println("leaving " + method.getName());
			return result;
		}
	}
	
	public interface IService {
		void sayHello();
	}
	
	public static class RealService implements IService {
		
		@Override
		public void sayHello() {
			System.out.println("hello");
		}
	}
}
