package com.demo.task.service;

import com.demo.chat.po.Task;
import com.demo.task.dao.TaskDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskService {

    @Resource
    private TaskDao taskDao;
    public Iterable<Task>  findByGroupId(String groupId){
        return taskDao.findByGroupId(groupId);
    }
    public Iterable<Task> findAllTask(){
        return taskDao.findAll();
    }
    public void deleteByGroupId(String groupId){
        taskDao.deleteByGroupId(groupId);
    }
    public void save(Task task){
        taskDao.save(task);
    }
}
