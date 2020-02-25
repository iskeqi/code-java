package com.keqi.springbootredislettuce;

import com.keqi.springbootredislettuce.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootRedisLettuceApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void expire() {
        redisUtil.expire("runoobkey", -1, TimeUnit.DAYS);
    }

}
