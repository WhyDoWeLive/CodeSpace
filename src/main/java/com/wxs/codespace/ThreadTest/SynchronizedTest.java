package com.wxs.codespace.ThreadTest;

import com.wxs.codespace.MyInterceptor;

public class SynchronizedTest {
    static String name = "wxs";
    static {
        System.out.println(name);
        MyInterceptor myInterceptor = new MyInterceptor();
    }

    public static void fuzhi(){
        System.out.println("heh");
        name = "xn";
    }

    private int lock = 0;
    public static void main(String[] args){
        new Thread(new RunImpl()).start();
        new Thread(new RunImpl()).start();
    }


    private static class RunImpl implements Runnable{
        private static String staticLock = "";
        @Override
        public void run() {
            try {
                print4();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * synchronized+实例方法：锁住的是实例对象，会同时执行，线程间不影响
         */
        public synchronized void print1() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + ": prepare");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ": finish");
        }


        /**
         * ？？？synchronized+普通string对象，为什么不会同时执行，而线程间会有影响呢？
         */
        public synchronized void print2() throws InterruptedException {
            String lock = "";
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + ": prepare");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + ": finish");
            }
        }

        /**
         * synchronized+this实例：会同时执行，锁住的是各自的对象，线程间不影响
         */
        public synchronized void print3() throws InterruptedException {
            String lock = "";
            synchronized (this){
                System.out.println(Thread.currentThread().getName() + ": prepare");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + ": finish");
            }
        }

        /**
         * synchronized+静态对象：会同时执行，锁住的是各自的对象，线程间不影响
         */
        public void print4() throws InterruptedException {
            String lock = "";
            synchronized (staticLock){
                System.out.println(Thread.currentThread().getName() + ": prepare");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + ": finish");
            }
        }

        /**
         * synchronized+静态对象：会同时执行，锁住的是各自的对象，线程间不影响
         */
        public static void print5() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + ": prepare");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ": finish");
        }
    }
}
