package com.wxs.codespace;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class SpringTest {
    @Value("${spring.redis.host}")
    private static String redisHost;

    @Autowired
    private static Environment env;

    public static void main(String[] args){
        System.out.println(redisHost);
        System.out.println(env.getProperty("spring.redis.port"));
    }
}
