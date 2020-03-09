package com.wxs.codespace.GoogleApiTest;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CacheTest {
    public static void main(String[] args){
        test1();

    }

    //Google的cache占用的是进程的内存
    private static void test1(){
        Cache<String, String> localCache = CacheBuilder.newBuilder().build();
        String value = localCache.getIfPresent("key_test1");
        if (value == null){
            System.out.println("there is nothing in cache");
            localCache.put("key_test1", "value_test1");
            System.out.println("put to cache : " + localCache.getIfPresent("key_test1"));
            System.out.println("waiting 5 second..... get from cache");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("get from cache : " + localCache.getIfPresent("key_test1"));
    }
}
