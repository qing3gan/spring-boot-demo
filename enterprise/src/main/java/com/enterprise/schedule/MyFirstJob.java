package com.enterprise.schedule;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/24 20:52
 */
@Component
public class MyFirstJob {
    public void firstJob() {
        System.out.println("firstJob: " + LocalTime.now());
    }
}
