package com.wxs.codespace.GoogleApiTest;

import com.google.common.cache.*;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test6();
    }

    //Google的cache占用的是进程的内存
    private static void test1(){
        Cache<String, String> localCache = CacheBuilder.newBuilder().build();
        String value = localCache.getIfPresent("key_test1");
        if (value == null){
            System.out.println("进程启动，内存里啥也没有");
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

    //get时，key-value不存在的加载方式一: LoadingCache + CacheLoader
    private static void test2(){
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return "default-value: wxs nb";
                    }
                });
        try {
            System.out.println("before put wxs, get: " + cache.get("wxs"));
            cache.put("wxs", "really NB");
            System.out.println("after put wxs, get: " + cache.get("wxs"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //get时，key-value不存在的加载方式二：Cache+Callable或lambda
    private static void test3() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder().build();
        System.out.println(cache.get("wxs", ()->{return "default-value: wxs nb";}));
        cache.put("wxs", "really NB");
        System.out.println(cache.get("wxs", ()->{return "default-value: wxs nb";}));
    }

    //基于容量回收，超过容量，则按照LRU策略回收
    private static void test4(){
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(10)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return "Default-value: wxs-nb";
                    }
                });

        for (int i = 0;i < 20; i++){
            cache.put(i+"", i+"");
            System.out.println("Size: " + cache.size());
            System.out.println("Map: " + cache.asMap());
        }
    }

    //定时回收1，expireAfterAccess：固定时长内未读写则回收
    private static void test5() throws InterruptedException, ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterAccess(3, TimeUnit.SECONDS).build();
        cache.put("wxs", "reallyNB");
        System.out.println(cache.get("wxs", ()->{return "default nb";}));
        Thread.sleep(5000);
        System.out.println(cache.get("wxs", ()->{return "default nb";}));
    }

    //定时回收2
    private static void test6() throws ExecutionException, InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS).build();
        cache.put("wxs", "reallyNB");
        System.out.println(cache.get("wxs", ()->{return "default nb";}));
        Thread.sleep(5000);
        System.out.println(cache.get("wxs", ()->{return "default nb";}));
    }

    //引用回收，没有尝试成功，因为没有等到GC触发，System.gc()只是建议触发GC，并不一定会真的触发GC
    private static void test7() throws ExecutionException, InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder().weakKeys().build();
        cache.put("wxs", "reallyNB");
        System.out.println(cache.get("wxs", ()->{return "default nb";}));

        while(cache.size()>0){
            System.gc();
            System.out.println(cache.size());
            Thread.sleep(2000);
        }

        System.out.println(cache.size());
    }
}
