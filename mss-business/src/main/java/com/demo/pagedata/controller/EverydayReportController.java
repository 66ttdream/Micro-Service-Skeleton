package com.demo.pagedata.controller;


import com.demo.chat.po.EverydayReport;
import com.demo.chat.util.UUID;
import com.demo.pagedata.service.EverydayReportService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("EverydayReport")
@Api(tags = "日常报告")
public class EverydayReportController {
    @Resource
    public EverydayReportService everydayReportService;

    @GetMapping("find")
    @ApiImplicitParam(name="userName",value="用户名",required=true,dataType="String")
    public Result findByUser(String userName){
        return Result.ok(everydayReportService.findByUser(userName));
    }
    @PostMapping("save")
    @ApiImplicitParam(name="everydayReport",value="日常报告内容",required=true,dataType="EverydayReport")
    public Result save(EverydayReport everydayReport){
        everydayReport.setId(UUID.getUUID());
        everydayReportService.save(everydayReport);
        return Result.ok();
    }

    @GetMapping("getOne")
    public Result getOne(String id){
       return Result.ok(everydayReportService.findOne(id).get());
    }
}
