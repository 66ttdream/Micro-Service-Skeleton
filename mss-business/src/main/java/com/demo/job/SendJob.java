package com.demo.job;

import com.alibaba.fastjson.JSON;
import com.demo.chat.controller.ChatController;
import com.demo.pagedata.dto.BackLogCount;
import lombok.SneakyThrows;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author liuji
 * 任务调度类
 */
public class SendJob  extends QuartzJobBean {

    @SneakyThrows
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //System.out.println("job被启动。。。。。。。。。。。。。。。。。。。。。");
        long a = 1;
        BackLogCount b = new BackLogCount("定时任务组",a);
        String jsonStr = JSON.toJSONString(b);
        ChatController.sendInfo(jsonStr,"backlog");
    }
}

