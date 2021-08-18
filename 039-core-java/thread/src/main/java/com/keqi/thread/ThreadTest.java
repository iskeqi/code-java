package com.keqi.thread;

import java.util.concurrent.*;

public class ThreadTest {
    public static void main(String[] args) {
        Object obj;
        // 适合用来执行不太耗时的一次性的任务
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 用于执行定时任务
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        // Java 中停止一个线程，有两种方式。
        // 第一种是直接使用 stop() 方法强制杀死线程，但是这种方法过于粗暴，很可能引起程序崩溃，不推荐使用。
        // 第二种是通过 interput() 方法通知目标线程，让目标线程主动的结束


        Thread t1 = new Thread(() -> {
            // 当前线程处理类
        });
        t1.setUncaughtExceptionHandler((t, e) -> {
            // 这也是可以处理异常的，不过还是建议直接在 run() 方法内部进行显示的 try catch 异常捕获
        });


        ScheduledExecutorService delayExecutorService = Executors.newScheduledThreadPool(10);
        // 基于线程池实现延时任务，搭配数据库轮询，是单机环境下很好的一种延时任务的实现方案
        // delayExecutorService.schedule()

        // JDK 中实现的阻塞队列，用来实现生产者/消费者这种线程协作机制
        BlockingQueue<Runnable> blockingQueue;
        BlockingDeque<Runnable> blockingDeque;
        ArrayBlockingQueue<Runnable> arrayBlockingQueue;
        LinkedBlockingDeque<Runnable> linkedBlockingDeque;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue;
        PriorityBlockingQueue<Runnable> priorityBlockingQueue;

        /*
            线程协作的几种典型场景：
                1、生产者、消费者模式（基于阻塞队列实现）
                2、同时开始
                3、等待结束（基于计数器，比如 CountDownLatch）
                4、异步结果（让线程对象拥有返回值，JDK 中提供了 Future 接口和 FutureTask 实现类）
                5、集合点（JDK 中提供了 CyclicBarrier）
         */
        Future<Integer> future;
    }
}
