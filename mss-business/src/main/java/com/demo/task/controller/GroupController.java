package com.demo.task.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.chat.po.Task;
import com.demo.chat.po.TaskGroup;
import com.demo.chat.util.UUID;
import com.demo.task.dto.GroupDto;
import com.demo.task.service.TaskGroupService;
import com.demo.task.service.TaskService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/taskgroup")
@Api(tags =  "任务组api")
public class GroupController {
    @Resource
    private TaskGroupService taskGroupService;
    @Resource
    private TaskService taskService;

    @ApiOperation(value = "创建任务组")
    @PostMapping("/creat")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Result newGroup(@RequestBody  GroupDto dto){
        String id = UUID.getUUID();
        TaskGroup taskGroup = dto.getTaskGroup();
        taskGroup.setId(id);
        //System.out.println(JSONObject.toJSON(dto));
        taskGroupService.create(taskGroup);
        List<Task> l = dto.getTasks();
        for(Task t:l){
            t.setGroupId(id);
            taskService.save(t);
        }
        return Result.ok("操作成功");
    }

    @ApiOperation(value = "获取所有任务组")
    @GetMapping("getall")
    public Result findAll(){
        return Result.ok(taskGroupService.findAll());
    }

    @ApiOperation(value = "删除指定任务组")
    @PostMapping("delete")
    @ApiImplicitParams(@ApiImplicitParam(name="groupId",value="任务组id",required=true))
    public Result deleteGroup(String groupId){
        taskGroupService.delete(groupId);
        if(taskService.findByGroupId(groupId)!=null){
            taskService.deleteByGroupId(groupId);
        }
        return Result.ok();
    }

}
