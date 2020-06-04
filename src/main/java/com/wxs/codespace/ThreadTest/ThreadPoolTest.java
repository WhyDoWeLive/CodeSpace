package com.wxs.codespace.ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试5种线程池实现
 */
public class ThreadPoolTest {
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    ExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();


    /**
     * 测试newFixedThreadPool
     */
    public void fixedThreadPoolTest() throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        //提交runnable任务
        fixedThreadPool.submit(() -> System.out.println("this is fixedThreadPoolTest execute runnable"));

        //提交callable任务
        String callableRes = fixedThreadPool.submit(() -> "this is fixedThreadPoolTest execute callable").get();
    }

    /**
     * 测试newScheduledThreadPool
     */
    public void scheduledThreadPool(){
        ExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(2);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        threadPoolTest.fixedThreadPoolTest();
    }
}
