package com.wxs.codespace.AnnotationTest.SpringFramworkAnnotationTest;

import org.springframework.beans.factory.annotation.Value;

public class ValueAnnotationTest {
    @Value("${spring.redis.port}")
    private String port;
}
