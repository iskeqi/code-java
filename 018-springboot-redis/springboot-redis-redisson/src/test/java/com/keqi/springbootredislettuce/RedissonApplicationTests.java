package com.keqi.springbootredislettuce;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//@Slf4j
@SpringBootTest
class RedissonApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void expire() {
        System.out.println("start ...");

        String MAP_KEY = "REDISSON";
        String LIST_KEY = "LISTR";

        for (int i = 0; i < 100; i++) {
            redisTemplate.opsForValue().set("key" + i, String.valueOf(i));


            redissonClient.getKeys().delete("key" + i);

            // redissonClient.getMap(MAP_KEY,new StringCodec()).

            // 使用 RedissonClient 时,需要指定编解码对象 Codec
            redissonClient.getMap(MAP_KEY, StringCodec.INSTANCE).put("key" + i, String.valueOf(i));

            Object value = redissonClient.getMap(MAP_KEY, StringCodec.INSTANCE).get("key" + i);

            // log.info("putMap key{},value{}", MAP_KEY, value);
            System.out.println("putMap key " + MAP_KEY + " value " + value);


            // 此处没有指定编解码对象,可以用全局配置
            redissonClient.getList(LIST_KEY).add(String.valueOf(i));


//            org.redisson.codec.MarshallingCodec l;
//            org.redisson.client.codec.StringCodec;
            // org.redisson.client.codec.StringCodec  codec;
        }
        List<Object> objects = redissonClient.getList(LIST_KEY).readAll();
        System.out.println(JSON.toJSONString(objects));

        RList<String> rList = redissonClient.getList("ABCD");
        System.out.println("rList size " + rList.size());

        rList.add("A");
        rList.add("B");
        rList.add("C");
        rList.add("D");

        RList<String> abcd = redissonClient.getList("ABCD");
        for (String s : abcd) {
            System.out.println(s);
        }

        System.out.println("end ...");
    }

    @Test
    void lock() {
        RLock lock = redissonClient.getLock("anyLock");
        AtomicInteger integer = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long l = System.currentTimeMillis() + 10000;
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        boolean success = false;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis > l) {
                            lock.lock();
                            try {
                                System.out.println(finalI + " " + currentTimeMillis);
                            } finally {
                                lock.unlock();
                                success = true;
                            }
                        }
                        if (success) {
                            integer.incrementAndGet();
                            return;
                        }
                    }
                }
            });
        }

    }
}
