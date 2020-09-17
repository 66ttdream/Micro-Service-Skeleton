package com.demo.pagedata.controller;

import com.demo.chat.po.BackLog;
import com.demo.pagedata.service.BackLogService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("backlog")
@Api(tags = "流程数据api")
public class BackLogController {
    @Resource
    private BackLogService backLogService;

    @ApiOperation(value = "添加流程数据")
    @PostMapping("save")
    public Result save(BackLog backLog){
        backLogService.add(backLog);
        return Result.ok();
    }

    @ApiOperation(value = "获取用户流程数据")
    @GetMapping("load")
    public Result get(String userName){
        return Result.ok(backLogService.findByName(userName));
    }

    @ApiOperation(value = "审批流程")
    @PostMapping("valve")
    public Result deleByName(String id){
        //return Result.ok(backLogService.findByName(userName));
        backLogService.deleteById(id);
        return Result.ok();
    }
}
