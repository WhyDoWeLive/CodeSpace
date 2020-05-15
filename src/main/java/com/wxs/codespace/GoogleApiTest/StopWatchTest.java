package com.wxs.codespace.GoogleApiTest;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class StopWatchTest {
    public static void main(String[] args) throws InterruptedException {
        //Creates (and starts) a new stopwatch using System.nanoTime() as its time source.
        //System.nanoTime():Returns the current value of the running Java Virtual Machine's high-resolution time source, in nanoseconds.
        //System.nanoTime():This method can only be used to measure elapsed time and is not related to any other notion of system or wall-clock time
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(2000);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
