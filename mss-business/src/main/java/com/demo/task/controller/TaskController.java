package com.demo.task.controller;

import com.demo.chat.po.Task;
import com.demo.chat.util.UUID;
import com.demo.task.service.TaskService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/task")
@Api(tags ="任务页面api")
public class TaskController {
    @Resource
    private TaskService taskService;

    //获取所有task
    @ApiOperation(value = "保存任务页面")
    @PostMapping("save")
    public Result saveTask(@RequestBody List<Task> task){
        taskService.addNew();
        for(Task t:task){
            if(t.getGroupId()!=null){
            }
            if(t.getGroupId()==null){
                t.setId(UUID.getUUID());
                taskService.save(t);
            }

            /*t.setId(UUID.getUUID());
            taskService.save(t);*/
        }
        return Result.ok("保存成功");
    }

    @GetMapping("getAll")
    @ApiOperation(value = "获取所有工作事项")
    public Result findAll() {
        return Result.ok(taskService.findAllTask());
    }

    @GetMapping("/grouptask")
    @ApiOperation(value = "获取事务组下的所有工作事项")
    public Result getByGroup(String groupId){
        return Result.ok(taskService.findByGroupId(groupId));
    }

    @ApiOperation(value = "工作组中移除指定工作事项")
    @PostMapping("/deleteagroup")
    public Result deleteByGroup(String groupId){
        taskService.deleteByGroupId(groupId);
        return Result.ok("操作成功");
    }
}
