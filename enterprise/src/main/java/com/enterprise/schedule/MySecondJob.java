package com.enterprise.schedule;

import lombok.Setter;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalTime;

/**
 * desc
 *
 * @author agony
 * @date 2020/5/24 20:52
 */
public class MySecondJob extends QuartzJobBean {
    @Setter
    private String name;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("secondJob: " + name + LocalTime.now());
    }
}
