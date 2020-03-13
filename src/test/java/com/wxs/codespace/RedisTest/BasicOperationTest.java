package com.wxs.codespace.RedisTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * 参考：https://www.ibm.com/developerworks/cn/java/know-redis-and-use-it-in-springboot-projects/index.html
 */
@SpringBootTest
public class BasicOperationTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void StringTest(){
        //String的Set和Get测试
        stringRedisTemplate.opsForValue().set("test-string-value", "set string");
        System.out.println(stringRedisTemplate.opsForValue().get("test-string-value"));

        //超时测试
        stringRedisTemplate.opsForValue().set("expired_for_3s", "hello_redis", 10, TimeUnit.SECONDS);

        //删除数据
        stringRedisTemplate.delete("test-string-value");
    }
}
