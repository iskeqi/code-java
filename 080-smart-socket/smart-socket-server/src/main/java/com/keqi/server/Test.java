package com.keqi.server;

import cn.hutool.core.util.HexUtil;

import java.nio.charset.StandardCharsets;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.test1();
    }

    public void test1() {
//        String HEADER = "ITL";
//
//        // 字符串转字节数组
//        byte[] headerBytes = HEADER.getBytes(StandardCharsets.UTF_8);
//        System.out.println(headerBytes.length);
//        for (byte headerByte : headerBytes) {
//            System.out.println(headerByte + " -> " + Integer.toHexString(headerByte));
//        }
//
//        byte[] bytes = HexUtil.decodeHex("16");
//        String ste = new String(bytes);
//        System.out.println(ste);
        String str = "      ";
        String s = HexUtil.decodeHexStr(str);
        System.out.println(s);
        String str1 = "49544C";
        String str2 = "16";
        String str3 = "00";
        String str4 = "01";
        String str5 = "1001";
        String str6 = "7B2274696D656F7574223A22363030227D";
        String str7 = "77";


        System.out.println(HexUtil.decodeHexStr(str1));
        System.out.println(HexUtil.decodeHexStr(str2));
        //System.out.println(new String(HexUtil.decodeHex(str2)));
        System.out.println(HexUtil.decodeHexStr(str3));
        System.out.println(HexUtil.decodeHexStr(str4));
        System.out.println(HexUtil.decodeHexStr(str5));
        System.out.println(HexUtil.decodeHexStr(str6));
        System.out.println(HexUtil.decodeHexStr(str7));
    }
}
