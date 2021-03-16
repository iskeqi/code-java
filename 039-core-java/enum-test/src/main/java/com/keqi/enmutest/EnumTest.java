package com.keqi.enmutest;

public class EnumTest {

    public static void main(String[] args) {
        // 解决方案一，每个枚举类都直接在内部提供一个方法
        // System.out.println(TaskStatusEnum.getName(2));

        // 解决方案二，使用统一工具类通过反射的方式根据 code 获取 codeName
        String name = EnumUtil.getCodeName(TaskStatusEnum.class, 2);
        System.out.println(name);
    }
}
