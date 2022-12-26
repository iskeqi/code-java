package com.keqi.springbootmvcsource;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CountUtil {

    public static final AtomicInteger count = new AtomicInteger();

    public AtomicInteger getCount() {
        return count;
    }
}
