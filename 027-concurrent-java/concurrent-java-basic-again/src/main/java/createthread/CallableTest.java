package createthread;

import java.util.concurrent.*;

public class CallableTest {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 传统方式
		executorService.submit(new Callable1());
		// 通过匿名内部类的方式
		executorService.submit(new Callable<Boolean>() {
			public Boolean call() throws Exception {
				System.out.println("线程名称：" + Thread.currentThread().getName());
				return true;
			}
		});
		// 通过 lambda 的方式
		executorService.submit(() -> {
			System.out.println("线程名称：" + Thread.currentThread().getName());
			return true;
		});
		executorService.shutdown();
	}

	/**
	 * 通过实现 Callable 接口的方式创建线程
	 */
	static class Callable1 implements Callable<Boolean> {
		public Boolean call() throws Exception {
			System.out.println("线程名称：" + Thread.currentThread().getName());
			return false;
		}
	}

	private static void testFutureTask() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		// 这里使用到了 FutureTask 类，其实也没有麻烦到哪里去
		FutureTask<?> futureTask = new FutureTask<>(() -> {
			System.out.println("Callable 接口的线程开始执行了...");
			Thread.sleep(10000);
			System.out.println("Callable 接口的线程结束执行了...");
			return null;
		});
		executorService.submit(futureTask);

		Thread.sleep(3000);
		System.out.println(futureTask.cancel(true));

		executorService.shutdown();
	}

	private static void testFuture() throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		// 这里默认使用 Future 接口，其实内部可能返回的就是 FutureTask 实例
		Future<?> future = executorService.submit((Callable<?>) () -> {
			System.out.println("Callable 接口的线程开始执行了...");
			Thread.sleep(10000);
			System.out.println("Callable 接口的线程结束执行了...");
			return null;
		});

		Thread.sleep(3000);
		System.out.println(future.cancel(true));

		executorService.shutdown();
	}
}
