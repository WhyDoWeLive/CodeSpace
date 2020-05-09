package com.wxs.codespace.ScheduledTasks;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 10s后，任务每3s执行一次
 */
public class TimerTest {
    public static void main(String[] args){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task run: " + new Date());
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 10000, 3000);
    }
}
