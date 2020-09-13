package com.demo.pagedata.controller;

import com.demo.chat.po.BackLog;
import com.demo.pagedata.service.BackLogService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("backlog")
public class BackLogController {
    @Resource
    private BackLogService backLogService;

    @PostMapping("save")
    public Result save(BackLog backLog){
        backLogService.add(backLog);
        return Result.ok();
    }

    @GetMapping("load")
    public Result get(String userName){
        backLogService.findByName(userName);
        return Result.ok();
    }
}
