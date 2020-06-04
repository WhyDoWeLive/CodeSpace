package com.wxs.codespace.DesignPattern.Singleton;

/**
 * 饿汉式
 * 缺点：无论什么情况都创建单例实例
 */
public class SingletonTest1 {
    private static SingletonTest1 singleton = new SingletonTest1();
    private SingletonTest1(){}

    public static SingletonTest1 getInstance(){
        return singleton;
    }
}
