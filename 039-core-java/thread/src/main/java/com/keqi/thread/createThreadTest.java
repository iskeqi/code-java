package com.keqi.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程有 3 种方式：
 * 1、继承 Thread 类，重写 run() 方法
 * 2、实现 Runnable 接口，实现 run() 方法
 * 3、实现 Callable 接口，实现 call() 方法
 */
public class createThreadTest {

    public static void main(String[] args) {
        // 执行线程有两种方式：
        //      1、通过 Thread 类的 start() 方法
        //      2、直接将任务对象丢进线程池中，有线程池中的消费者线程进行执行
        Thread1 t1 = new Thread1();
        t1.start();

        Thread t2 = new Thread(new Thread2());
        t2.start();

        /*Callable 接口，无法作为 Thread 类构造函数的参数
        Thread t3 = new Thread(new Thread3());
        t3.start();*/

        Thread3 t33 = new Thread3();
        Thread2 t22 = new Thread2();
        Thread1 t11 = new Thread1();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(t11);
        executorService.submit(t22);
        executorService.submit(t33);

        executorService.shutdown();
    }

    public static class Thread1 extends Thread {

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            System.out.println("Thread1 -> " + currentThread.getName() + "-> " + currentThread.getId()
                    + "-> " + currentThread.getPriority());
        }
    }

    public static class Thread2 implements Runnable {

        @Override
        public void run() {
            Thread currentThread = Thread.currentThread();
            System.out.println("Thread2 -> " + currentThread.getName() + "-> " + currentThread.getId()
                    + "-> " + currentThread.getPriority());
        }
    }

    public static class Thread3 implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread currentThread = Thread.currentThread();
            System.out.println("Thread3 -> " + currentThread.getName() + "-> " + currentThread.getId()
                    + "-> " + currentThread.getPriority());

            return "success";
        }
    }
}
