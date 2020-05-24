package threadgroup;

public class ThreadGroupTest {
	public static void main(String[] args) {
		System.out.println("main 线程的线程组名称："+ Thread.currentThread().getThreadGroup().getName());
		System.out.println("main 线程的默认优先级："+ Thread.currentThread().getPriority());

		Thread t1 = new Thread(() -> {
			try {
				// 这里通过睡眠来模拟，守护线程是会在所有前台线程都结束时，立即被迫结束的
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("t1 线程的线程组名称："+ Thread.currentThread().getThreadGroup().getName());
		});

		// 设置为守护线程后，程序会立即结束
		// 没有设置为守护线程时，程序就会等待10秒后才结束
		// t1.setDaemon(true);
		t1.start();

	}
}
