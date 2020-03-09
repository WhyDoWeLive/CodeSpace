package com.wxs.codespace.AnnotationTest;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public class LombokTest {
    String name;
    int age;

    public static void main(String[] args){
        LombokTest lombokTest = LombokTest.builder().name("wxs").age(23).build();
        System.out.println(lombokTest.name);
        System.out.println(lombokTest.age);
    }
}
