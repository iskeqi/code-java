package com.keqi.staticproxy;

/**
 * @author keqi
 */
public class SimpleStaticProxyDemo {
	
	/*
		静态代理模式：持有原有对象，并不改变原有对象的行为，但是会在原有基础上屏蔽或新增部分功能
		适配器模式：一个接口，不同实现类
		装饰器模式：持有原有对象，并部分改变了原有对象的行为
	 */
	
	public static void main(String[] args) {
		IService realService = new RealService();
		IService proxyService = new TraceProxy(realService);
		
		realService.sayHello();
		System.out.println("=======");
		proxyService.sayHello();
		
		// 如果希望在程序运行过程中动态去创建代理对象来对原有对象进行创建呢？那么就需要通过动态代理技术了
	}
	
	private interface IService {
		void sayHello();
	}
	
	private static class RealService implements IService {
		
		@Override
		public void sayHello() {
			System.out.println("hello");
		}
	}
	
	private static class TraceProxy implements IService {
		private final IService realService;
		
		public TraceProxy(IService realService) {
			this.realService = realService;
		}
		
		@Override
		public void sayHello() {
			System.out.println("entering sayHello");
			this.realService.sayHello();
			System.out.println("leaving sayHello");
		}
	}
}
