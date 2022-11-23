package com.keqi.springbootredislettuce;

import com.keqi.springbootredislettuce.util.RedisClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootRedisLettuceApplicationTests {

    @Autowired
    private RedisClient redisClient;

    @Test
    void expire() {
        //redisClient.expire("runoobkey", 1, TimeUnit.DAYS);
        redisClient.del("RDS");
    }

    @Test
    void set() {
        Properties properties = System.getProperties();
        redisClient.set("properties", properties);
    }

    @Test
    void get() {
        Properties properties = redisClient.get("properties", Properties.class);
        System.out.println(properties);
    }

}
