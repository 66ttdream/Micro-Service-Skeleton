package com.demo.task.controller;

import com.demo.chat.po.Task;
import com.demo.chat.util.UUID;
import com.demo.task.service.TaskService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    private TaskService taskService;

    //获取所有task
    @PostMapping("save")
    public Result saveTask(Task... task){
        for(Task t:task){
            t.setId(UUID.getUUID());
            taskService.save(t);
        }
        return Result.ok("保存成功");
    }

    @GetMapping("getAll")
    public Result findAll() {
        return Result.ok(taskService.findAllTask());
    }

    @GetMapping("/grouptask")
    public Result getByGroup(String groupId){
        return Result.ok(taskService.findByGroupId(groupId));
    }

    @PostMapping("/deleteagroup")
    public Result deleteByGroup(String groupId){
        taskService.deleteByGroupId(groupId);
        return Result.ok("操作成功");
    }
}
