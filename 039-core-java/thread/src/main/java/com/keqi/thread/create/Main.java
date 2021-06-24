package com.keqi.thread.create;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyThread t1 = new MyThread();
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // 实现了 Callable 接口的线程对象只能通过 ExecutorService 去执行
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> callable = executorService.submit(new MyCallable());
        System.out.println(callable.get());

        t1.join();
        t2.join();
    }

    // 继承 thread 类
    public static class MyThread extends Thread {
        @Override
        public void run() {
            test();
        }
    }

    // 实现 runnable 接口
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            test();
        }
    }

    // 实现 Callable 接口
    public static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return test();
        }
    }

    public static Integer test() {
        Integer count = 0;
        System.out.println(LocalDateTime.now().toString().replace('T',' ') + Thread.currentThread().getName());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            count++;
        }
        System.out.println(LocalDateTime.now().toString().replace('T',' ') + Thread.currentThread().getName() + " " + count);
        return count;
    }
}
