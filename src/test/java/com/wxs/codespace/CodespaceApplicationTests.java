package com.wxs.codespace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class CodespaceApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("test-string-value", "first-test-by-stringRedisTemplate");
        System.out.println(stringRedisTemplate.opsForValue().get("test-string-value"));
    }

}
