package com.demo.task.controller;

import com.demo.chat.po.TaskGroup;
import com.demo.chat.util.UUID;
import com.demo.task.service.TaskGroupService;
import com.demo.task.service.TaskService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/taskgroup")
public class GroupController {
    @Resource
    private TaskGroupService taskGroupService;

    @Resource
    private TaskService taskService;

    @PostMapping("/creat")
    public Result newGroup(TaskGroup taskGroup){
        taskGroup.setId(UUID.getUUID());
        taskGroupService.create(taskGroup);
        return Result.ok("操作成功");
    }


    @GetMapping("getall")
    public Result findAll(){
        return Result.ok(taskGroupService.findAll());
    }

    @PostMapping("delete")
    public Result deleteGroup(String groupId){
        taskGroupService.delete(groupId);
        taskService.deleteByGroupId(groupId);
        return Result.ok();
    }

}
