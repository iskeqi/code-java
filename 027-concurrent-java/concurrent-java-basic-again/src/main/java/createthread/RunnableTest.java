package createthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 传统方式
		executorService.submit(new Runnable1());
		// 通过匿名内部类的方式
		executorService.submit(new Runnable() {
			public void run() {
				System.out.println("线程名称：" + Thread.currentThread().getName());
			}
		});
		// 通过 lambda 的方式
		executorService.submit(() -> System.out.println("线程名称：" + Thread.currentThread().getName()));
		executorService.shutdown();
	}

	/**
	 * 通过实现 Runnable 接口的 run() 方法来创建线程
	 */
	static class Runnable1 implements Runnable {
		public void run() {
			System.out.println("线程名称：" + Thread.currentThread().getName());
		}
	}
}
