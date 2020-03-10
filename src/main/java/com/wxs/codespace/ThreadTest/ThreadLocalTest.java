package com.wxs.codespace.ThreadTest;

/**
 * 关注点1：两个线程将 static 的 sum 不断的加1后，sum变量的最终取值
 * 关注点2：两个线程将 static 的 threadLocal1 不断加1后，变量在两个线程中的取值
 * 关注点3：每个线程都用了两个threadLocal共存了2个值
 */
public class ThreadLocalTest{
    private static ThreadLocal<Integer> threadLocal_1 = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    private static ThreadLocal<String> threadLocal_2 = new ThreadLocal<>();
    private static int sum = 0;


    public static void main(String[] args){
        Thread t1 = new Thread(new RunImpl(), "thread-1");
        Thread t2 = new Thread(new RunImpl(), "thread-2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
        System.out.println("main_threadLocal1: " + threadLocal_1.get());
    }

    private static class RunImpl implements Runnable{

        @Override
        public void run() {
            for (int j = 0;j < 10000;++j){
                ++sum;
                threadLocal_1.set(threadLocal_1.get()+1);
            }
            threadLocal_2.set(Thread.currentThread().getName());
            System.out.println(threadLocal_2.get() + ", thread_local1: " + threadLocal_1.get());

            threadLocal_1.remove();
            threadLocal_2.remove();
        }
    }

}
