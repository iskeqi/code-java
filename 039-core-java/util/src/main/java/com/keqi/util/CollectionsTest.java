package com.keqi.util;

import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    public static void main(String[] args) {
        // 这个方法非常适合用来返回一个空的集合，避免NPE问题
        List emptyList = Collections.emptyList();

        System.out.println(emptyList.size());

        List emptyList1 = Collections.EMPTY_LIST;
        List<Object> objects = Collections.emptyList();


    }
}
