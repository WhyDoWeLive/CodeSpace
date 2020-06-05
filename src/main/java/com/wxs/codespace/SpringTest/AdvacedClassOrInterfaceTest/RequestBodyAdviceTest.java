package com.wxs.codespace.SpringTest.AdvacedClassOrInterfaceTest;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @ControllerAdvice(basePackages=".....")：设置需要当前RequestBodyAdvice执行的域，默认全局生效
 * RequestBodyAdvice只会作用在包含有被@RequestBody注解的参数的Controller的方法上，它的作用就是在
 * 被@RequestBody注解的参数被赋值前后，做一些事情(参见文档https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/mvc/method/annotation/RequestBodyAdvice.html)
 */
@ControllerAdvice
public class RequestBodyAdviceTest implements RequestBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        System.out.println("this is requestBodyAdvice's support:");
        System.out.println("methodParameterName: " + methodParameter.getParameterName());
        System.out.println("methodParameter: " + methodParameter.getParameter());
        System.out.println("methodParameterClass: " + methodParameter.getDeclaringClass());
        System.out.println("type: " + type);
        System.out.println("aClass: " + aClass);
        System.out.println("=======");
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        System.out.println("beforeBodyRead");
        System.out.println("httpInputMessage: " + httpInputMessage);
        System.out.println("httpIputMessage.body: " + httpInputMessage.getBody());
        System.out.println("methodParameter: " + methodParameter);
        System.out.println("=======");
        return httpInputMessage;
    }

    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        System.out.println("afterBodyRead");
        System.out.println("httpInputMessage: " + httpInputMessage);
        System.out.println("methodParameter: " + methodParameter);
        System.out.println("o: " + o);
        System.out.println("=======");
        return o;
    }

    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        System.out.println("handleEmptyBody");
        System.out.println("=======");
        return o;
    }
}
