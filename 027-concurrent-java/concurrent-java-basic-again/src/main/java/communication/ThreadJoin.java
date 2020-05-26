package communication;

/**
 * 测试 Thread 类的 join() 方法，实现一个线程等待另一个线程执行完的效果
 */
public class ThreadJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("t1");
			}
		});
		t1.start();

		Thread.sleep(100);
		t1.join(); // 无限等待t1 线程执行完，才继续往下执行
	}
}
