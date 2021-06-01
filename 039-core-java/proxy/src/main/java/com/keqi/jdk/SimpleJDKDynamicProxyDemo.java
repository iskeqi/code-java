package com.keqi.jdk;

/**
 * @author keqi
 */
public class SimpleJDKDynamicProxyDemo {
	
	public static void main(String[] args) {
		IService realService = new RealService();
		
		// 静态代理：先编写好对应的类代码，JVM加载对应的 .class 文件，并在内存中创建对应的 Class 对象，并创建实例对象
		// 动态代理：直接通过字节码的方式生成代理类的 Class 对象(!!!!)，再通过反射对象创建实例对象
			// 类代码在程序运行之后，创建对象之前，才确定。但不是通过代码生成的方式，而是通过字节码的方式生成 Class 对象
		
		// Proxy 类 和 CgLib 库提供的方法，仅仅是操作的API而已。真正的思想就是上面提的这种！！！
		
		// 所谓动态代理，指的是类代码是动态的，对象其实仅仅是类的一个实例而已
		/*IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.invoke(null, args);
			}
		});*/
		
		/*IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
				new Class<?>[] { IService.class }, new SimpleInvocationHandler(realService));*/
		// proxyService.sayHello();
	}
	
	/*static class SimpleInvocationHandler implements InvocationHandler {
		private final Object realObj;
		
		public SimpleInvocationHandler(Object realObj) {
			this.realObj = realObj;
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("entering " + method.getName());
			Object result = method.invoke(realObj, args);
			System.out.println("leaving " + method.getName());
			return result;
		}
	}*/
	
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
