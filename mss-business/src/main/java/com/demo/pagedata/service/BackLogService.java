package com.demo.pagedata.service;

import com.demo.chat.po.BackLog;
import com.demo.pagedata.dao.BackLogDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BackLogService {
    @Resource
    private BackLogDao backLogDao;
    public void add(BackLog backLog){
        backLogDao.save(backLog);
    }

    public void delete(BackLog backLog){
        backLogDao.delete(backLog);
    }
    public void findByName(String userName){
        backLogDao.findByUserName(userName);
    }
}
