package com.wxs.codespace.IOCTest;


import com.wxs.codespace.SpringTest.IOCTest.JavaBean1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * 所有的@*Test注解(即以Test结尾的注解，这里是SpringBootTest)都被@BootstrapWith注解，
 * 它们可以启动ApplicationContext，是测试的入口，所有的测试类必须声明一个@*Test注解
 */
@SpringBootTest
public class IOCTest {
    //这个bean的声明是通过@Component+自动扫描
    @Autowired
    public JavaBean1 bean1;

    //这个bean的声明是通过Configurantion来声明的
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void printBeanName(){
        bean1.printBeanName();
    }

    @Test
    public void redisTest(){
        stringRedisTemplate.opsForValue().set("test-string-value-wxs", "first-test-by-stringRedisTemplate");
        System.out.println(stringRedisTemplate.opsForValue().get("test-string-value-wxs"));
    }

}
