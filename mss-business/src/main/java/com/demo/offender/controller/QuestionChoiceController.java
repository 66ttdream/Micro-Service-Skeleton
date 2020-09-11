package com.demo.offender.controller;

import com.demo.chat.po.QuestionChoice;
import com.demo.chat.util.UUID;
import com.demo.offender.service.QuestionChoiceService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/questionchoice")
public class QuestionChoiceController {
    @Resource
    private QuestionChoiceService questionChoiceService;

    @RequestMapping("/save")
    public Result save(QuestionChoice questionChoice){
        questionChoice.setId(UUID.getUUID());
        questionChoiceService.save(questionChoice);
        return Result.ok("操作成功");
    }

}
