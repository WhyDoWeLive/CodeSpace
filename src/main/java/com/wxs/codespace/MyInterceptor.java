package com.wxs.codespace;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import scala.Serializable;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.HashTable;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyInterceptor implements MethodInterceptor {

    class TargetClass{

    }

    protected void prin(){}

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //做一些其它事情
        methodProxy.invokeSuper(o, objects);       //被代理对象的调用，入参分别为被代理对象及参数
        //做一些其它事情
        return null;
    }

    public TargetClass getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetClass.class);  //传入被代理对象
        enhancer.setCallback(new MyInterceptor());  //设置方法拦截器
        return (TargetClass) enhancer.create();  //创建动态代理对象
    }

    public static class MySet<E> extends HashSet<E>{

        int name;
    }

    public static void main(String[] args){

        MySet mySet = new MySet();
        mySet.add("a");

        HashSet hashSet = new HashSet();
        hashSet.add("a");

        System.out.println(mySet.equals(hashSet));
        System.out.println(hashSet.equals(mySet));
        System.out.println(hashSet==(mySet));
    }
}