package com.keqi.concurrentjavabasic.poll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 测试 java.util.concurrent.Executors 类的常用方法
 */
public class ExecutersTest {

	/*
		阿里巴巴规范中不建议使用Executors类创建线程池，推荐使用手动设置，能够更清晰线程池的各种参数，避免OOM。

		但是不代表说这个类的相关方法就没有用了，你完全可以点进去，把人家的源码复制出来，再直接用啊！

		如果你及团队本身对线程池非常熟悉，又确定业务规模不会大到资源耗尽的程度（比如线程数量或任务队列长度可能达到Integer.MAX_VALUE）时，
		其实是可以使用JDK提供的这几个接口的，它能让我们的代码具有更强的可读性。
	*/
	public static void main(String[] args) {
		// 线程池中的不同参数，决定了线程池的不同性能，能够用在不同的范围

		/*
			当需要执行很多短时间的任务时，CacheThreadPool的线程复用率比较高， 会显著的提高性能。
			而且线程60s后会回收，意味着即使没有任务进来，CacheThreadPool并不会占用很多资源。
		 */
		ExecutorService executorService = Executors.newCachedThreadPool();

		/*
			由于线程不会被回收，会一直卡在阻塞，所以没有任务的情况下， FixedThreadPool占用资源更多。
		 */
		ExecutorService executorService1 = Executors.newFixedThreadPool(100);

		/*
			不会创建非核心线程。所有任务按照先来先执行的顺序执行。如果这个唯一的线程不空闲，那么新来的任务会存储在任务队列里等待执行。
		*/
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();

		/*
			创建一个定长线程池，支持定时及周期性任务执行。

			延时任务：schedule()
			固定间隔任务：scheduleAtFixedRate()
		 */
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(100);
		// scheduledExecutorService.schedule()
		// scheduledExecutorService.scheduleAtFixedRate()


		/*
			总结：
				1) 以上四种常见的线程池基本够我们使用了
				2) 并不是一个程序里面，只可以创建一个线程池，而是允许根据不同的使用场景创建多个线程池的，
						事实上也确实应该这么做。
				3) 尽管如此，但还是建议使用hutoll封装好的类来使用，这样子更加方便
		 */
	}
}
