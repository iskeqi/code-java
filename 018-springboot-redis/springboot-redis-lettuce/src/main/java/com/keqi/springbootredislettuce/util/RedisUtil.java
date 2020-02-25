package com.keqi.springbootredislettuce.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类
 *
 * 方法命名同Redis命令相同，毕竟API其实就是命令的代码实现方式而已
 *
 * @author keqi
 */
@Component
public class RedisUtil {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisUtil(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 指定 key 的失效时间
     * @param key key
     * @param time time 必须大约0，如果小于等于0 ，则相当于直接删除这个key
     * @param timeUnit 时间单位(天/小时/分钟/秒/毫秒/微秒/纳秒)
     * @return r
     */
    public boolean expire(String key, long time, TimeUnit timeUnit) {
        if (time > 0) {
            return stringRedisTemplate.expire(key, time, timeUnit);
        }
        return false;
    }

}
