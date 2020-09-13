package com.demo.task.service;


import com.demo.chat.po.TaskGroup;
import com.demo.task.dao.TaskGroupDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskGroupService {
    @Resource
    private TaskGroupDao taskGroupDao;

    public void create(TaskGroup taskGroup){
        taskGroupDao.save(taskGroup);
    }

    public Iterable<TaskGroup> findAll(){
        return taskGroupDao.findAll();
    }

    public void delete(String groupId){
        taskGroupDao.deleteByGroupId(groupId);
    }
}
