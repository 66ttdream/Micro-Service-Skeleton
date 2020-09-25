package com.demo.task.controller;

import com.demo.chat.po.Cron;
import com.demo.chat.po.Task;
import com.demo.chat.po.TaskGroup;
import com.demo.chat.util.GenerateCronUtil;
import com.demo.chat.util.UUID;
import com.demo.job.JobService;
import com.demo.pagedata.service.CronService;
import com.demo.task.dto.GroupDto;
import com.demo.task.service.TaskGroupService;
import com.demo.task.service.TaskService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.*;
import org.quartz.SchedulerException;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/taskgroup")
@Api(tags =  "任务组api")
public class GroupController{
    @Resource
    private TaskGroupService taskGroupService;
    @Resource
    private TaskService taskService;
    @Resource
    private CronService cronService;

    @Resource
    private JobService jobService;

    @ApiOperation(value = "创建任务组")
    @PostMapping("/creat")
    public Result newGroup(@RequestBody  GroupDto dto) throws SchedulerException {
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
        cronService.saveOne(Cron.builder()
                .id(UUID.getUUID())
                .group_name(dto.getName())
                .task_count(dto.getTasks().size())
                .user_name(dto.getUserName())
                .cron(GenerateCronUtil.getCron(dto.getCycle(),dto.getWarningTime()))
                .build());
        //new TimerTask(GenerateCronUtil.getCron(dto.getCycle(),dto.getWarningTime()));
        System.out.println("Cycle:"+GenerateCronUtil.getCron(dto.getCycle(),dto.getWarningTime()));
        jobService.buildJob(GenerateCronUtil.getCron(dto.getCycle(),dto.getWarningTime()),UUID.getUUID());
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
    public Result deleteGroup(String id){
        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii:"+id);
        taskGroupService.delete(id);
        if(taskService.findByGroupId(id)!=null){
            taskService.deleteByGroupId(id);
        }
        cronService.deleteByGroup(id);
        return Result.ok();
    }
    @GetMapping("test")
    public void test(String s) throws SchedulerException {
        jobService.buildJob(s,UUID.getUUID());
    }

}

