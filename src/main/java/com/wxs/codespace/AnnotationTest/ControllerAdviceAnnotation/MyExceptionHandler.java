package com.wxs.codespace.AnnotationTest.ControllerAdviceAnnotation;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 捕获所有controller的所有未捕获的异常
 * 验证：在随便一个Controller中抛异常，如1/0，目前还不知道怎么把返回值返回到前端
 */
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String printException(Exception e){
        System.out.println("some controller throw an exception");
        System.out.println(e);
        return "some controller throw an exception";
    }
}
