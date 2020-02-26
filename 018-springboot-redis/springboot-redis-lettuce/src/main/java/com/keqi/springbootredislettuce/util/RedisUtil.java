package com.keqi.springbootredislettuce.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类
 *
 * 1) 序列化对象到Redis时尽可能全部在该工具类外部转成JSON，再存储进Redis
 * 2) 如果需要该工具类中没有的方法，一律遵循这种编码方式自行补充
 *
 * @author keqi
 */
@Component
public class RedisUtil {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisUtil(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    // =============================key的操作============================ //

    /**
     * 指定 key 的失效时间
     * @param key key
     * @param time time 必须大约0，如果小于等于0 ，则相当于直接删除这个key
     * @param timeUnit 时间单位(天/小时/分钟/秒/毫秒/微秒/纳秒)
     */
    public void expire(String key, long time, TimeUnit timeUnit) {
        if (time > 0) {
            stringRedisTemplate.expire(key, time, timeUnit);
        }
    }

    /**
     *  根据key 获取过期时间
     * @param key key
     * @param timeUnit 时间单位(天/小时/分钟/秒/毫秒/微秒/纳秒)
     * @return r
     */
    public Long getExpire(String key, TimeUnit timeUnit) {
        return stringRedisTemplate.getExpire(key, timeUnit);
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true 存在 false不存在
     */
    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 删除指定 key
     * @param key 可以传一个值 或多个
     */
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                stringRedisTemplate.delete(key[0]);
            } else {
                stringRedisTemplate.delete(Arrays.asList(key));
            }
        }
    }

    // =============================string类型的操作============================ //

    /**
     * 获取 string 类型的 key 对应的值
     * @param key key
     * @return r
     */
    public String get(String key) {
        return key == null ? null : stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 获取 string 类型的 key 对应的值
     * @param key key
     * @param clazz 泛型返回对象
     * @return r
     */
    public <T> T get(String key, Class<T> clazz) {
        String jsonStr = stringRedisTemplate.opsForValue().get(key);
        return jsonStr == null ? null : JSON.parseObject(jsonStr, clazz);
    }

    /**
     * 设置 string 类型的value (无过期时间限制)
     * @param key key
     * @param value value
     */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置 string 类型的value (无过期时间限制)
     * @param key key
     * @param value value 对象（直接把对象序列化成JSON再存储进Redis中）
     */
    public void set(String key, Object value) {
        String jsonStr = JSON.toJSONString(value, SerializerFeature.WriteMapNullValue);
        stringRedisTemplate.opsForValue().set(key, jsonStr);
    }

    /**
     * 设置 string 类型的value (指定期时间限制)
     * @param key key
     * @param value value
     * @param timeout timeout 必须大约0，如果小于等于0 ，则相当于没有设置过期时间
     * @param unit unit 时间单位(天/小时/分钟/秒/毫秒/微秒/纳秒)
     */
    public void set(String key, String value, long timeout, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 设置 string 类型的value (指定期时间限制)
     * @param key key
     * @param value value 对象（直接把对象序列化成JSON再存储进Redis中）
     * @param timeout timeout 必须大约0，如果小于等于0 ，则相当于没有设置过期时间
     * @param unit unit 时间单位(天/小时/分钟/秒/毫秒/微秒/纳秒)
     */
    public void set(String key, Object value, long timeout, TimeUnit unit) {
        String jsonStr = JSON.toJSONString(value, SerializerFeature.WriteMapNullValue);
        stringRedisTemplate.opsForValue().set(key, jsonStr, timeout, unit);
    }

    // =============================hash类型的操作============================ //


}
