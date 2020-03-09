package com.wxs.codespace.ThreadTest;

import java.util.concurrent.*;

public class ThreadPool_Runnable_Callable_FutureTask {
    public static void main(String args[]){
        try {
            fixedThreadPoolTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试一、Submit(Runnable)
     * 测试二、Submit(Runnable implement By Lambda)，因为Runnable是函数式接口，所以可以用Lambda表达式实现
     * 测试三、Submit(Callable)
     * 测试四、Submit(Callable implement By Lambda)，因为Callable是函数式接口，所以可以用Lambda表达式实现
     * 测试五、Submit(FutureTask)
     *
     * 测试一和测试二无法获取到线程的返回结果，其余的可以获取(get)到返回结果。并且get时，若线程未计算完成，则阻塞，直到拿到结果。
     */
    private static void fixedThreadPoolTest() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);

        //测试一
        es.submit(new PrintRunnable());

        //测试二
        es.submit(() -> new PrintRunnable().run());

        //测试三
        Future<Integer> res1 = es.submit(new PrintCallable());
        System.out.println("PrintCallable res:" + res1.get());
        System.out.println("阻塞解除");

        //测试四
        Future<Integer> res2 = es.submit(() -> new PrintCallable().call());
        System.out.println("PrintCallable res:" + res2.get());
        System.out.println("阻塞解除");

        //测试五
        FutureTask<Integer> futureTask = new FutureTask<>(new PrintCallable());
        es.submit(futureTask);
        System.out.println("拿到结果:" + futureTask.get());
        System.out.println("阻塞解除");
        es.shutdown();
    }

    /**
     * 统一Runnable: 输出0~9，间隔1秒
     */
    private static class PrintRunnable implements java.lang.Runnable {
        @Override
        public void run() {
            for (int i = 0;i < 10;++i) {
                System.out.println("PrintRunnable: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 统一Callable: 返回1123
     */
    private static class PrintCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            try {
                System.out.println("PrintCallable: begin and wait 3000ms");
                Thread.sleep(3000);
                System.out.println("PrintCallable: end..");
            }catch (Exception e){
                e.printStackTrace();
            }

            return 1123;
        }
    }

}
