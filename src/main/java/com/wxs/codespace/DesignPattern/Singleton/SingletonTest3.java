package com.wxs.codespace.DesignPattern.Singleton;

/**
 * 懒汉式（双重校验）
 * 双重校验：第一重——不必每次都加锁；第二重——只创建一次锁
 */
public class SingletonTest3 {
    private static SingletonTest3 singleton = null;
    private SingletonTest3(){}
    public static SingletonTest3 getInstance(){
        if (singleton == null){
            synchronized (SingletonTest3.class){
                if (singleton == null){
                    singleton = new SingletonTest3();
                }
            }
        }

        return singleton;
    }
}
