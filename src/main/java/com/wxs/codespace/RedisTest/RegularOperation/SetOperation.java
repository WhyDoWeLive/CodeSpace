package com.wxs.codespace.RedisTest.RegularOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class SetOperation {
    @Autowired
    private static StringRedisTemplate stringRedisTemplate;

    public static void main(String[] args){
        stringRedisTemplate.opsForValue().set("test-string-value", "first-test-by-stringRedisTemplate");
        System.out.println(stringRedisTemplate.opsForValue().get("test-string-value"));
    }
}
