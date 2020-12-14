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

        // 比较两个 BigDecimal 数的大小（使用 equals 方法会比较每一个字符串，使用 compareTo 方法比较的才是数字对应的大小）
        BigDecimal a1 = new BigDecimal("100.000");
        BigDecimal b1 = new BigDecimal("100");
        System.out.println(a1.equals(b1)); // 输出为 false
        System.out.println(a1.compareTo(b1)); // 输出为 0
        System.out.println(a1.compareTo(b1) == 0); // 输出为 true

        // 只要存在浮点数，就使用 BigDecimal 来处理就行，禁止在程序中使用 Float 和 Double
        // MySQL 中浮点数直接使用 decimal 类型，在序列化VO到前端时，可以通过@JsonSerialize注解的using属性指定序列化方式，然后自定义一个序列化类即可，
        // 参考链接如下：https://segmentfault.com/a/1190000022755526
        //            https://blog.csdn.net/weter_drop/article/details/103374041
        BigDecimal a2 = new BigDecimal("100.0320040000");
        System.out.println(a2.stripTrailingZeros()); // 去掉后缀中的0
    }
}
