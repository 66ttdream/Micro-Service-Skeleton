package com.demo.pagedata.service;


import com.demo.task.service.TaskGroupService;
import com.demo.task.service.TaskService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class InitTask implements ApplicationRunner {
    /*@Resource
    RedisTemplate<String,String> redisTemplate;
    @Resource
    TaskGroupService taskGroupService;
    @Resource
    TaskService taskService;
    @Override*/
    public void run(ApplicationArguments args) throws Exception {

    }
}
