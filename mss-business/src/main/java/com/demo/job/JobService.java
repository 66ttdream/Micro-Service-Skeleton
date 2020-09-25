package com.demo.job;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuji
 * 动态定时任务的执行类
 */
@Service
public class JobService {

    @Autowired
    private Scheduler quartzScheduler;

    //private String cron;

    public void buildJob(String cron,String jobId) throws SchedulerException {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        JobDetail jobDetail = JobBuilder.newJob(SendJob.class)
                // (name,group) 用于定位任务
                .withIdentity(jobId,"quartzTaskJob").build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobId,"quartzTaskJob")
                .withSchedule(scheduleBuilder).build();
        //定义触发器将触发器与任务绑定到调度器内
        quartzScheduler.scheduleJob(jobDetail, trigger);
        //启动
        quartzScheduler.start();
    }
}

