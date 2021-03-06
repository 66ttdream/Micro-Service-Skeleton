package com.demo.offender.controller;

import com.demo.chat.po.QuestionChoice;
import com.demo.chat.util.UUID;
import com.demo.offender.service.QuestionChoiceService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/questionchoice")
@Api(tags = "问卷调查api")
public class QuestionChoiceController {
    @Resource
    private QuestionChoiceService questionChoiceService;

    @ApiOperation(value = "保存问卷调查信息")
    @PostMapping("/save")
    public Result save(QuestionChoice questionChoice){
        questionChoice.setId(UUID.getUUID());
        questionChoice.setSubmit_time(new Date());
        questionChoiceService.save(questionChoice);
        return Result.ok("操作成功");
    }

    @ApiOperation(value = "获取问卷调查信息")
    @GetMapping("all")
    public Result all(){
        return Result.ok(questionChoiceService.findAll());
    }

}
