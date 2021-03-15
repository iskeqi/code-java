package com.keqi.thread.future;

import java.time.LocalDateTime;
import java.util.concurrent.Future;

public class DataXTask implements Runnable {


    public boolean cancelDataXTask(Future<Boolean> future) {
        // cancel(false) 取消已经提交但还没有被运行的任务
        // cancel(true) 会取消所有已经提交的任务，包括正在等待的和正在运行的

        future.cancel(true);
        return false;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        String s = LocalDateTime.now().toString();
        boolean result = false;
        long num = 1000000033L;
        for (long i = 2; i < num; i++) {
            // Thread.currentThread().isInterrupted() 可以判断当前线程是否收到中断通知
            if (num % i == 0) {
                result = true;
                break;
            }
            /*if (Thread.currentThread().isInterrupted()) {
                break;
            }*/
        }

        String e = LocalDateTime.now().toString();
        long end = System.currentTimeMillis();
        System.out.println("开始执行时间：" + s + " 结束执行时间：" + e + " 总共耗时：" + (end - start) / 1000);
    }
}
