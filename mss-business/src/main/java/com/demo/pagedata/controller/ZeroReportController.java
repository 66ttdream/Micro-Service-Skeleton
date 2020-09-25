package com.demo.pagedata.controller;


import com.demo.chat.po.ZeroReport;
import com.demo.chat.util.UUID;
import com.demo.pagedata.service.ZeroReportService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("ZeroReport")
@Api(tags = "零报告api")
public class ZeroReportController {
    @Resource
    private ZeroReportService zeroReportService;

    @GetMapping("find")
    @ApiImplicitParam(name="userName",value="用户名",required=true,dataType="String")
    public Result findByUser(String userName){
        return Result.ok(zeroReportService.findByUser(userName));
    }

    @PostMapping("save")
    @ApiImplicitParam(name="zeroReport",value="零报告实体",required=true,dataType="ZeroReport")
    public Result save(ZeroReport zeroReport){
        if(zeroReport.getId()==null){
            zeroReport.setId(UUID.getUUID());
        }
        zeroReportService.save(zeroReport);
        return Result.ok();
    }
    @GetMapping("getOne")
    @ApiImplicitParam(name="id",value="id",required=true,dataType="String")
    public Result findById(String id){
        return Result.ok(zeroReportService.findOne(id).get());
    }
}
