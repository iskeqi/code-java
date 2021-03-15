package com.keqi.thread.future;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
       /* ExecutorService executorService = Executors.newCachedThreadPool();
        // 此任务在当前机器上需要执行6秒
        DataXTask dataXTask = new DataXTask();
        Future<Boolean> future = executorService.submit(dataXTask);

        // 以下是线程任务自然执行完了的情况下
        *//*Boolean aBoolean = null;
        try {
            aBoolean = future.get();
        } catch (InterruptedException e) {
            // 当前线程被中断了
        } catch (ExecutionException e) {
            // 目标线程抛出了异常
        }
        System.out.println(aBoolean);*//*


        // 等待两秒钟后，测试调用Future的cancel()方法是否能够取消目标任务线程的执行
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // 当前线程被中断了
        }

        // 尽管此方法返回为 true ，但是实际上目标任务仍然在被执行
        *//*boolean cancel = future.cancel(true);
        System.out.println(cancel);*//*

        // 直接调用 cancel() 方法其实卵用没有，毕竟这只是起到一个通知的作用，目标任务中没有提供对应的任务结束的实现
        // 每一个目标任务类都应该在其内部提供任务取消的方法
        dataXTask.cancelDataXTask(future);*/
    }
}
