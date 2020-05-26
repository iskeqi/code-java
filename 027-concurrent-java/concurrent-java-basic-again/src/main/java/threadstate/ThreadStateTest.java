package threadstate;

public class ThreadStateTest {
	public static void main(String[] args) throws InterruptedException {
		test4();
	}

	private static void test4() {
		Thread a = new Thread(() -> {
			int i = Integer.MIN_VALUE;
			do {
				i++;
				if (i == -5) {
					Thread.interrupted(); // 中断线程(还是没有效果！！！)
				}
			} while (i < 0);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}, "a");
		a.start();
	}



	private static void test3() {
		Thread a = new Thread(() -> {
			int i = Integer.MIN_VALUE;
			for (;;) {
				// 一个死循环
			}
		}, "a");

		Thread b = new Thread(() -> {
			try {
				a.join(); // 如果一个线程中调用了另一个线程对象的 join 方法，那么这个线程就会处于 WAITING 状态
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "b");

		a.start();
		b.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程 a 处于 RUNNABLE 状态：" + a.getState());
		System.out.println("线程 b 处于 WAITING 状态：" + b.getState());
		System.out.println("线程 a 是否被中断：" + a.isInterrupted());
		System.out.println("线程 a 是否还存活着：" + a.isAlive());
		a.interrupt(); // 仅仅是设置了线程的中断状态为 true ，但是实际上这个线程不会立马就结束，完全取决于线程自己，甚至不一定有效
		System.out.println("---线程 a 是否被中断：" + a.isInterrupted());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("---线程 a 是否还存活着：" + a.isAlive());
	}

	/**
	 * 测试线程处于 BLOCKED/TIME_WAITING
	 */
	private static void test2() {
		// 这里是人为的让线程处于阻塞状态，实际程序运行过程中，代码虽然不长这样，但是线程阻塞的时候原因差不多
		Object obj = new Object();
		Thread a = new Thread(() -> {
			synchronized (obj) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "a");
		Thread b = new Thread(() -> {
			synchronized (obj) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "b");
		a.start();
		b.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程 a 处于 TIME_WAITING 状态：" + a.getState());
		System.out.println("线程 b 处于 BLOCKED 状态：" + b.getState());
	}


	/**
	 * 测试线程的 NEW/RUNNABLE/TERMINATED 状态
	 */
	private static void test1() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "a");
		System.out.println("此时线程处于 NEW（新建） 状态：" + t1.getState());

		t1.start();
		System.out.println("此时线程处于 RUNNABLE（运行） 状态：" + t1.getState());

		try {
			Thread.sleep(5000); // 这里纯粹是防止 a 线程还没有执行完，main 线程就往下执行了，导致得不到 a 的终止状态
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("此时线程处于 TERMINATED（终止） 状态：" + t1.getState());
	}
}
