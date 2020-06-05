package com.wxs.codespace.ThreadTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 这样是有问题的：所有tomcat为用户开启的10个线程共享i的值
 */
//@RestController
//public class ControllerAndMultiThread {
//    private int i = 0;
//
//    @RequestMapping("testMultiThreadWithController")
//    public String testMultiThreadWithController(){
//        System.out.println(Thread.currentThread().getName());
//        return String.valueOf(i++);
//    }
//}

/**
 * 每个tomcat为用户开启的线程拥有一个i，这个i只在当前线程里去改变
 * 如果不加ThreadLocal.remove，则不同用户请求由同一个tomcat线程去请求时，则会得到不同的i（累加）
  */
@RestController
public class ControllerAndMultiThread {
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    @Value("${spring.redis.port}")
    private String port;
    @GetMapping({"testMultiThreadWithController", "anotherPath"})
    public String testMultiThreadWithController(String arg1){
        System.out.println(arg1);
        System.out.println(Thread.currentThread().getName());
        threadLocal.set(threadLocal.get()+1);
        String i = String.valueOf(threadLocal.get());
        threadLocal.remove();
        System.out.println("==========" + port);
        return i;
    }
}
