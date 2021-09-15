package com.keqi.thread.waitnotify;

public class Main {

    public static void main(String[] args) {
        // 18446744073709551615
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        // 两个 int 类型的数字，通过字符串的方式拼接出来的数字比 bigint unsigned 都要大很多
        System.out.println("18446744073709551615");
        System.out.println(Integer.MAX_VALUE + "" + Integer.MAX_VALUE);

        String a = "18446744073709551615";
    }
}
