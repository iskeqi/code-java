package com.keqi.springbootredislettuce;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@SpringBootTest
class RedissonApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void testTransaction() {
        log.info("开启事务");
        redisTemplate.multi();
        log.info("修改 k1 的值为 111");
        redisTemplate.opsForValue().set("k1", "111111111");
        log.info("修改 k2 的值为 222");
        redisTemplate.opsForValue().set("k2", "222222222");
        log.info("提交事务");
        redisTemplate.exec();
        log.info("事务执行完成");
    }

    @Test
    void testTransaction2() {
        List<Object> objects = redisTemplate.executePipelined(new SessionCallback<List<Object>>() {
            @Override
            public <K, V> List<Object> execute(RedisOperations<K, V> operations) throws DataAccessException {
                log.info("开启事务");
                operations.multi();
                log.info("修改 k1 的值为 111");
                operations.opsForValue().set((K) "k1", (V) "111");
                log.info("修改 k2 的值为 222");
                operations.opsForValue().set((K) "k2", (V) "222");
                log.info("提交事务");
                List<Object> exec = operations.exec();
                log.info("事务执行完成");
                for (Object o : exec) {
                    log.info("{} ", o);
                }
                return null;
            }
        });
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    void testTransaction3() {
        //execute a transaction
        List<Object> txResults = redisTemplate.execute(new SessionCallback<List<Object>>() {
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                operations.opsForSet().add("key1", "value1");

                // This will contain the results of all operations in the transaction
                return operations.exec();
            }
        });
        System.out.println("Number of items added to set: " + txResults.get(0));
    }

    @Test
    void testTransaction4() {
        List<Object> executeResult = redisTemplate.execute(new SessionCallback<List<Object>>() {
            @Override
            public List<Object> execute(RedisOperations redisOperations) throws DataAccessException {
                // 进行强制类型转换,可以更方便的使用
                StringRedisTemplate operations = (StringRedisTemplate) redisOperations;

                // 监视 k3 和 k4 这两个 key
                List<String> list = new ArrayList<>();
                list.add("k3");
                list.add("k4");
                operations.watch(list);

                // 开启事务
                operations.multi();

                // 设置 k3 的值为 333
                operations.opsForValue().set("k3", "333");

                // 在 setK5 集合中添加 123
                Long setK5 = operations.opsForSet().add("k3", "123");
                // 在 setK5 集合中添加 1233
                Long setK33 = operations.opsForSet().add("k3", "1233");

                // 设置 k4 的值为 444
                operations.opsForValue().set("k4", "444");

                // 提交事务,并以列表的方式返回事务中所有命令的返回值
                return operations.exec();
            }
        });

        if (executeResult != null) {
            for (Object result : executeResult) {
                log.info("{} ", result);
            }
        }

    }

    @Test
    void optimisticLock() {
        String optimisticLock = "optimisticLock";

        redisTemplate.opsForValue().set(optimisticLock, "1000");

        String result = redisTemplate.opsForValue().get(optimisticLock);
        log.info("result {}", result);
        if (result == null) {
            return;
        }





        List<Object> executeResult = redisTemplate.execute(new SessionCallback<List<Object>>() {
            @Override
            public List<Object> execute(RedisOperations redisOperations) throws DataAccessException {
                StringRedisTemplate operations = (StringRedisTemplate) redisOperations;

                log.info("监视 {}", optimisticLock);
                redisTemplate.watch(optimisticLock);
                redisTemplate.opsForValue().set(optimisticLock, "10000");
                operations.multi();

                operations.opsForValue().set(optimisticLock, String.valueOf(Integer.parseInt(result) + 1));

                return operations.exec();
            }
        });

        if (executeResult != null) {
            for (Object r : executeResult) {
                log.info("{}", r);
            }
        }
    }

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
