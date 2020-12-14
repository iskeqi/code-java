package com.keqi;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("100");
        BigDecimal b = new BigDecimal("3");

        // 加法
        System.out.println(a.add(b));

        // 减法
        System.out.println(a.subtract(b));

        // 乘法
        System.out.println(a.multiply(b));

        // 除法(四舍五入，保留两位小数)
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));

        // 除法(UP，保留两位小数)
        System.out.println(a.divide(b, 2, RoundingMode.UP));
    }
}
