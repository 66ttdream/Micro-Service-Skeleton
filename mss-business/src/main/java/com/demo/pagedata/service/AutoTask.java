package com.demo.pagedata.service;

import com.demo.chat.controller.ChatController;
import com.demo.chat.po.Cron;
import com.demo.pagedata.dao.CronDao;
import com.demo.pagedata.dto.BackLogMassageDto;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.Iterator;


/**
 * @author liuji
 * 定时任务执行类
 */
@Slf4j
@Component
@Setter
public class AutoTask implements SchedulingConfigurer {

    @Resource
    private CronDao cronDao;


    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Iterable<Cron> c = cronDao.findAll();
        Iterator<Cron> it = c.iterator();
        while(it.hasNext()){
            Cron cr = it.next();
            String cron = cr.getCron();
            String name = cr.getUser_name();
            Integer count = cr.getTask_count();
            String group = cr.getGroup_name();
            BackLogMassageDto dto  = new BackLogMassageDto();
            dto.setActivity_name(group);
            dto.setTypeNumber(count);
            scheduledTaskRegistrar.addTriggerTask(() -> {
                        try {
                            process(name,dto);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    },
                    triggerContext -> {
                        if (cron.isEmpty()) {
                            log.info("cron 为空");
                        }
                        return new CronTrigger(cron).nextExecutionTime(triggerContext);
                    }
            );
        }
        /*scheduledTaskRegistrar.addTriggerTask(() -> process(),
                triggerContext -> {
                    String cron = this.cron; //cronDao.findAll();
                    if (cron.isEmpty()) {
                        log.info("cron 为空");
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );*/
    }

    private void process(String acceptName, BackLogMassageDto backLogMassageDto) throws IOException {
        ChatController.sendInfo(backLogMassageDto.toString(),acceptName);
        //System.out.println("定时任务被执行：");
    }
}
