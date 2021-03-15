package com.keqi.thread.future;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        // 此任务在当前机器上需要执行6秒
        DataXTask dataXTask = new DataXTask();
        // 每隔 10 秒钟开始执行一次
        ScheduledFuture<?> future = scheduledExecutorService.scheduleWithFixedDelay(dataXTask, 0, 10, TimeUnit.SECONDS);

        // 以下是线程任务自然执行完了的情况下
        /*Object o = null;
        try {
             o = future.get();
        } catch (InterruptedException e) {
            // 当前线程被中断了
        } catch (ExecutionException e) {
            // 目标线程抛出了异常
        }
        System.out.println(o.toString());*/


        // 等待10秒钟后，测试调用Future的cancel()方法是否能够取消目标任务线程的执行
        try {
            Thread.sleep(19000);
        } catch (InterruptedException e) {
            // 当前线程被中断了
        }

        // 如果此时处于两次任务执行的间隔，即任务处于等待执行时，这种方式是可以取消任务的
        // 如果此时处于任务正在执行的状态下，这种方式并不会立即取消当前任务的执行，但是下一次以及以后都不会被执行，可见这种方式是满足需求的
        // 如果你希望当前任务执行时也立即生效，那么就必须要在任务中自行实现结束的逻辑了
        boolean cancel = future.cancel(true);
        System.out.println(cancel);

        // 直接调用 cancel() 方法其实卵用没有，毕竟这只是起到一个通知的作用，目标任务中没有提供对应的任务结束的实现
        // 每一个目标任务类都应该在其内部提供任务取消的方法
        //dataXTask.cancelDataXTask(future);
    }
}
