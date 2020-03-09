package com.wxs.codespace.AnnotationTest.CustomizedAnnotation;

import java.lang.reflect.Method;

@LogAnnotation(message = "visit Test's method")
public class Test {
    @LogAnnotation(message = "invoke Test's hello method")
    public static void hello() throws NoSuchMethodException {
        /**
         * 获取类上的注解并输出msg
         */
        boolean hasAnnotation = Test.class.isAnnotationPresent(LogAnnotation.class);
        if (hasAnnotation){
            LogAnnotation logAnnotation = Test.class.getAnnotation(LogAnnotation.class);
            System.out.println(logAnnotation.message());
        }

        /**
         * 获取方法上的注解并输出
         */
        Method helloMethod = Test.class.getDeclaredMethod("hello");
        LogAnnotation logAnnotation = helloMethod.getAnnotation(LogAnnotation.class);
        System.out.println(logAnnotation.message());
    }

    public static void main(String args[]){
        try {
            hello();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
