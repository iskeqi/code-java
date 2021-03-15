package com.keqi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadTest {
    public static void main(String[] args) {

        // 适合用来执行不太耗时的一次性的任务
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 用于执行定时任务
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        // Java 中停止一个线程，有两种方式。
        // 第一种是直接使用 stop() 方法强制杀死线程，但是这种方法过于粗暴，很可能引起程序崩溃，不推荐使用。
        // 第二种是通过 interput() 方法通知目标线程，让目标线程主动的结束
    }
}
