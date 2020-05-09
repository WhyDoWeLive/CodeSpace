package com.wxs.codespace;

import com.wxs.codespace.RPCTest.SerializableTest.SerializablePersonTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Whatever2 implements Runnable{
    volatile int a = 0;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int a[] = {-2,-1};
        test2(a);
    }

    @Override
    public void run() {
        a++;
        System.out.println(a);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test2(int a[]){
        if (a.length<1){
            return;
        }

        int max = a[0];
        int maxStart = 0;
        int tmpMax = a[0];
        int tmpMaxStart = 0;
        for(int i = 1;i < a.length;++i){
            if (tmpMax+a[i] >= 0){
                tmpMax += a[i];
                if (tmpMax > max){
                    max = tmpMax;
                    maxStart = tmpMaxStart;
                }
            }
            else {
                tmpMax = 0;
                tmpMaxStart = i+1;
            }
        }
        System.out.println(max);
        System.out.println(maxStart);
    }
}
