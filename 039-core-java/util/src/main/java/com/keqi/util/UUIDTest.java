package com.keqi.util;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        System.out.println(s.length());
        String simpleUUID = s.replace("-", "");
        System.out.println(simpleUUID);
        System.out.println(simpleUUID.length());
    }
}
