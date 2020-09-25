package com.demo.pagedata.controller;

import com.demo.chat.po.BackLog;
import com.demo.pagedata.dto.BackLogCount;
import com.demo.pagedata.service.AppointmentService;
import com.demo.pagedata.service.BackLogService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("backlog")
@Api(tags = "流程数据api")
public class BackLogController {
    @Resource
    private BackLogService backLogService;

    @Resource
    private AppointmentService appointmentService;

    @ApiOperation(value = "添加流程数据")
    @PostMapping("save")
    public Result save(BackLog backLog){
        backLogService.add(backLog);
        return Result.ok();
    }

    @ApiOperation(value = "获取用户流程数据")
    @GetMapping("load")
    @ApiImplicitParams(
            {@ApiImplicitParam(name="userName",value="用户名",required=true,dataType="String"),
             @ApiImplicitParam(name="activity_name",value="待办名称",required=true,dataType="String")})
    public Result get(String userName,String activity_name){
        return Result.ok(backLogService.findByName(userName,activity_name));
    }

    @ApiOperation(value = "审批流程")
    @PostMapping("valve")
    @ApiImplicitParam(name="id",value="待办事项唯一主键",required=true,dataType="String")
    public Result deleByName(String id){
        //return Result.ok(backLogService.findByName(userName));
        backLogService.deleteById(id);
        return Result.ok();
    }

    @ApiOperation(value = "获取类型及对应代办条数")
    @GetMapping("typecount")
    @ApiImplicitParam(name="userName",value="用户名",required=true,dataType="String")
    public Result getTypeAndCount(String userName){
        List<BackLogCount> list = backLogService.findTypeAnCount(userName);
        long count = appointmentService.count();
        BackLogCount backLogCount = new BackLogCount("预约会见",(int)count);
        list.add(backLogCount);
        return Result.ok(list);
    }
}
