package com.enterprise.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * Scheduled: Spring定时任务
 *
 * @author agony
 * @date 2020/5/24 20:43
 */
@Component
public class MySchedule {
    @Scheduled(fixedDelay = 1000)
    public void fixedDelay() {
        System.out.println("fixedDelay: " + LocalTime.now());
    }

    @Scheduled(fixedRate = 2000)
    public void fixedRate() {
        System.out.println("fixedRate: " + LocalTime.now());
    }

    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void initialDelay() {
        System.out.println("initialDelay: " + LocalTime.now());
    }

    @Scheduled(cron = "*/1 * * * * ?")
    public void cron() {
        System.out.println("cron: " + LocalTime.now());
    }
}
