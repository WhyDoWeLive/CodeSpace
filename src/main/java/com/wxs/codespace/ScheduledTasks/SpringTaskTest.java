package com.wxs.codespace.ScheduledTasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
/**
 * 需要在启动类上加上@EnableScheduling注解才会启动定时任务
 * 注意@Scheduled定时任务默认是多线程，如果有多个任务执行，则会有问题，比如task2执行时会等待task1的sleep(20)
 *
 * 配置成多线程的方式（配置类已经写好，直接放开@Async的注释就好了）：
 * 1、首先创建AsyncConfig配置类配置多线程（网上有很多通过在xml中添加<task>来做的），详见该文件
 * 2、在定时任务的类或者方法上加上@Async，则相应任务都跑在不同线程
 */
//@Async
public class SpringTaskTest {
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled() {
        System.out.println("Spring task: " + new Date());
        log.info("Spring task: " + new Date());
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void scheduled2(){
        System.out.println("Spring task2: " + new Date());
        log.info("Spring task2: " + new Date());
    }
}
