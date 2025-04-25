package com.harris.common.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @author Harris
 */
@SuppressWarnings({"unchecked", "rawtypes"})
@Component
public class RedisUtils {

    private final RedisTemplate redisTemplate;

    @Autowired
    public RedisUtils(@Qualifier("redisTemplate") RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public <T> T getCacheObject(final String key) {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        return (T) opsForValue.get(key);
    }

    public void removeCacheObject(final String key) {
        redisTemplate.delete(key);
    }

    public boolean hasCacheObject(String id) {
        return redisTemplate.hasKey(id);
    }
}
