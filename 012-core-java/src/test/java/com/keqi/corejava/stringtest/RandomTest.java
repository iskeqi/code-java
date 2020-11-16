package com.keqi.corejava.stringtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomTest {

    @Test
    public void test1() {
        for (int i = 0; i < 6; i++) {
            // 此方法本质上是使用的 java.util.Random 类 nextDouble() 方法
            double random = Math.random();
            System.out.println(random);
        }
    }

    @Test
    public void test2() {
        Random random = new Random();

        // 产生一个随机的整数(范围可能为正，也可能为负)
        System.out.println(random.nextInt());
        // 产生一个随机的整数(范围在[0,100))
        System.out.println(random.nextInt(100));

        // 产生一个随机的 boolean 数(范围在[true,false])
        System.out.println(random.nextBoolean());
        // 产生一个随机的 double 小数(范围在[0,1))
        System.out.println(random.nextDouble());
        // 产生一个随机的 float 小数(范围在[0,1))
        System.out.println(random.nextFloat());
        // 产生一个随机的 long 整数(范围可能为正，也可能为负)
        System.out.println(random.nextLong());

    }

    @Test
    public void test3() {
        // 设定了 Random 类的 seed 种子属性后，下面代码无论在哪个机器上，运行多少次都会输出一样的结果
        // 设定种子是为了实现可重复的随机
        Random random = new Random(1234);
        for (int i = 0; i < 5; i++) {
            System.out.print(random.nextInt(100) + " ");
        }
    }

    @Test
    public void test4() {
        // 生成一个 6 位的随机数
        List<Integer> list = new ArrayList<>(6);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            // 随机生成[0,10) 之间的整数
            list.add(random.nextInt(10));
        }
        // 输出结果：[2, 4, 5, 3, 9, 7]
        System.out.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void test5() {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        Random random = new Random();
        // 对数组中的每个数，进行随机的替换
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, random.nextInt(arr.length));
        }
        System.out.println(Arrays.toString(arr));
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test6() {
        for (int j = 0; j < 10; j++) {
            // 1 -> 30% ; 2 -> 10% ; 5 -> 5% ; 不中奖 -> 55% ;
            // [0,30)     [30,40)  [40,45) [45,100)
            Random random = new Random();
            int i = random.nextInt(100);
            if (i < 30) {
                System.out.println("中奖 1 元");
            } else if (i < 40) {
                System.out.println("中奖 2 元");
            } else if (i < 45) {
                System.out.println("中奖 5 元");
            } else {
                System.out.println("谢谢惠顾");
            }
        }

    }
}
