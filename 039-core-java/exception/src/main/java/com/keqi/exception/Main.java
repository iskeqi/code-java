package com.keqi.exception;

public class Main {

    public static void main(String[] args) {
        组装异常栈信息字符串并打印至控制台中();
    }

    private static void 组装异常栈信息字符串并打印至控制台中() {
        try {
            throw new RuntimeException("gfdsgfsdgs");
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            StringBuilder str = new StringBuilder(e.toString() + "\n");
            for (StackTraceElement t : stackTrace) {
                System.out.println(e.toString()); // 异常名称
                System.out.println(t.getClassName()); //完整类名
                System.out.println(t.getFileName());// 文件名
                System.out.println(t.getLineNumber()); // 行号
                System.out.println(t.getMethodName()); // 方法名
  
                // 通过以上 5 个字段就能够拼接处整个异常栈的
                str.append("    " + "at " + t.getClassName() + "." + t.getMethodName() + "(" +
                        t.getFileName() + ":" + t.getLineNumber() + ")" + "\n");
            }
            System.out.println(str.toString());
            System.out.println("============");
            e.printStackTrace();
        }
    }

    private static void 测试JVM处理如何处理异常() {
        String s = null;
        // int a = s.indexOf("a"); // 此处会抛出 NullPointerException 异常，并且是 JVM 内部抛出的，而不是方法内部显示抛出的
        System.out.println(System.currentTimeMillis());

        String number = "abc";
        // int i = Integer.parseInt(number); // 此处会抛出 NumberFormatException 异常，这是由此方法通过 throw 语句输出的
        // System.out.println(i);

        // 未经捕获的异常抛在当前线程的整个方法调用栈中没有被处理时，会导致当前线程直接结束，进入到终止状态！！！！！
        Runnable runnable = new Runnable() {
            public void run() {
                throw new RuntimeException();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        try {
            System.out.println("开始阻塞");
            Thread.sleep(3000);
            System.out.println("结束阻塞");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("xxxxxxxxxxxxxxx");
    }


}
