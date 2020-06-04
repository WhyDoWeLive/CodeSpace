package com.wxs.codespace.SpringTest.IOCTest;

import org.springframework.stereotype.Component;

/**
 * 组件扫描：Spring会寻找带有@Component的类并为其创建bean，在test中测试
 */
@Component
public class JavaBean1 {
    private String beanName;
    public JavaBean1(){
        beanName = "Bean1";
    }

    public void printBeanName(){
        System.out.println(beanName);
    }
}
