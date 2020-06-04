package com.wxs.codespace.DesignPattern.Singleton;

/**
 * 懒汉式
 * 缺点：每次都要加锁
 */
public class SingletonTest2 {
    private static SingletonTest2 singleton = null;
    private SingletonTest2(){}

    public static synchronized SingletonTest2 getInstance(){
        if (singleton == null){
            singleton = new SingletonTest2();
        }
        return singleton;
    }
}
