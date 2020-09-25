package com.demo.pagedata.service;

import com.demo.chat.po.BackLog;
import com.demo.pagedata.dao.BackLogDao;
import com.demo.pagedata.dto.BackLogCount;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public Iterable<BackLog> findByName(String userName,String activity_name){
        return backLogDao.findByUserNameAndActivity_name(userName,activity_name);
    }

    public void deleteById(String id){
        backLogDao.deleteById(id);
    }

    public List<BackLogCount> findTypeAnCount(String userName){
        return backLogDao.findTypeAnCount(userName);
    }
}
