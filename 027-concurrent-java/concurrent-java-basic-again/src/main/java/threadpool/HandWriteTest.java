package threadpool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HandWriteTest {
	public static void main(String[] args) {

	}

	class ThreadPool {
		// 任务队列
		private BlockingQueue<Runnable> taskQueue;

		// 线程集合
		private HashSet<Worker> workers = new HashSet();

		// 核心线程数
		private int coreSize;

		// 设置超时时间
		private long timeout;

		// 超时时间单位
		private TimeUnit unit;

		// 执行任务
		public void execute(Runnable task) {
			// 任务数没有超过核心线程个数时，直接交给 worker 对象执行
			// 如果任务超过 coreSize 时，则加入任务队列暂存
			synchronized (workers) {
				if (workers.size() < coreSize) {
					Worker worker = new Worker(task);
					workers.add(worker);
					worker.start();
				}
				else {
					taskQueue.put(task);
				}
			}
		}

		public ThreadPool(int coreSize, long timeout, TimeUnit unit, int queueCapicty) {
			this.coreSize = coreSize;
			this.timeout = timeout;
			this.unit = unit;
			this.taskQueue = new BlockingQueue<>(queueCapicty);
		}

		class Worker extends Thread {
			private Runnable task;
			public Worker(Runnable task) {
				this.task = task;
			}

			@Override
			public void run() {
				// 执行任务
				// 当 task 不为空，执行任务
				// 当 task 执行完毕，再接着从任务队列获取任务
				while (task != null || (task = taskQueue.take()) != null) {
					try {
						task.run();
					} catch (Exception e) {

					} finally {
						task = null;
					}
				}
				synchronized (workers) {
					workers.remove(this);
				}
			}
		}
	}

	class BlockingQueue<T> {
		// 1. 任务队列
		private Deque<T> queue = new ArrayDeque<>();

		// 2. 锁
		private ReentrantLock lock = new ReentrantLock();

		// 3. 生产者条件变量
		private Condition fullWaitSet = lock.newCondition();

		// 4. 消费者条件变量
		private Condition emptyWaitSet = lock.newCondition();

		// 5. 容量
		private int capcity;

		public BlockingQueue(int capcity) {
			this.capcity = capcity;
		}

		// 带超时时间的阻塞获取
		public T poll (long timeout, TimeUnit unit) {
			lock.lock();
			try {
				// 转换为纳秒
				long nanos = unit.toNanos(timeout);
				while (queue.isEmpty()) {
					try {
						// 返回的是剩余的时间
						if (nanos <= 0) {
							return null;
						}
						nanos = emptyWaitSet.awaitNanos(nanos);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				T t = queue.removeFirst();
				fullWaitSet.signal();
				return t;
			} finally {
				lock.unlock();
			}
		}

		// 阻塞获取
		public T take() {
			lock.lock();
			try {
				while (queue.isEmpty()) {
					try {
						emptyWaitSet.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				T t = queue.removeFirst();
				fullWaitSet.signal();
				return t;
			} finally {
				lock.unlock();
			}
		}

		public void put(T element) {
			lock.lock();
			try {
				while (queue.size() == capcity) {
					try {
						fullWaitSet.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				queue.addLast(element);
				emptyWaitSet.signal();
			} finally {
				lock.unlock();
			}
		}

		public int size() {
			lock.lock();
			try {
				return queue.size();
			} finally {
				lock.unlock();
			}
		}
	}
}
