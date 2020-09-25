package com.demo.pagedata.service;

import com.demo.chat.po.Cron;
import com.demo.pagedata.dao.CronDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CronService {
    @Resource
    private CronDao cronDao;
    public void saveOne(Cron cron){
        cronDao.save(cron);
    }

    public void deleteByGroup(String group_id){
        cronDao.deleteCronByGroup_id(group_id);
    }

}
