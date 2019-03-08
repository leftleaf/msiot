package com.example.device.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {
    @Autowired
    private RedisTemplate redisTemplate;

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    @SuppressWarnings("unchecked")
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @SuppressWarnings("unchecked")
    public void set(String key, Object value, int timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    @SuppressWarnings("unchecked")
    public void expire(String key, int timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }
}
