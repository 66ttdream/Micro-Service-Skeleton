package com.demo.pagedata.controller;


import com.demo.chat.po.SentimentReport;
import com.demo.chat.util.UUID;
import com.demo.pagedata.service.SentimentReportService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("SentimentReport")
@RestController
@Api(tags = "舆情报告api")
public class SentimentReportController {
    @Resource
    private SentimentReportService sentimentReportService;


    @ApiImplicitParam(name="userName",value="用户名",required=true,dataType="String")
    @GetMapping("find")
    public Result findByUser(String userName){
        return Result.ok(sentimentReportService.findByUserName(userName));
    }

    @PostMapping("save")
    @ApiImplicitParam(name="sentimentReport",value="舆情报告内容",required=true,dataType="SentimentReport")
    public Result save(SentimentReport sentimentReport){
        if(sentimentReport.getId()==null){
            sentimentReport.setId(UUID.getUUID());
        }
        sentimentReportService.save(sentimentReport);
        return Result.ok();
    }
    @ApiImplicitParam(name="id",value="id",required=true,dataType="String")
    @GetMapping("getOne")
    public Result getOne(String id){
        return Result.ok(sentimentReportService.fingOne(id).get());
    }
}
