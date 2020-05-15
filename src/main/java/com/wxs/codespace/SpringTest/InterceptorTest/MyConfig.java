package com.wxs.codespace.SpringTest.InterceptorTest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 除了/oldHome以外的所有请求都将被拦截器重定向到/oldhome
         */
        registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/oldHome");
    }
}