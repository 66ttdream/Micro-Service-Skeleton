package com.demo.offender.controller;


import com.alibaba.fastjson.JSONObject;
import com.demo.chat.controller.ChatController;
import com.demo.chat.po.CriminalBase;
import com.demo.chat.util.UUID;
import com.demo.offender.service.CriminalBaseService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("criminalbase")
@Api(tags = "罪犯基础信息api")
public class CriminalBaseController {
    @Resource
    private CriminalBaseService criminalBaseService;

    @ApiOperation(value = "查询所有信息")
    @GetMapping("all")
    public Result getAll(){
        return Result.ok(criminalBaseService.findAll());
    }

    @ApiOperation(value = "删除单个信息")
    @PostMapping("deleteone")
    public Result deleteOne(String certificate_number){
        criminalBaseService.deleteOne(certificate_number);
        return Result.ok();
    }

    @ApiOperation(value = "新增单个信息")
    @PostMapping("addone")
    public Result addOne(CriminalBase criminalBase){
        //criminalBase.setCertificate_number(UUID.getUUID());
        criminalBase.setAdd_date(new Date());
        JSONObject js = new JSONObject();
        String message = js.toJSONString(criminalBase);
        try {
            ChatController.sendInfo(message,"system");
        } catch (IOException e) {
            e.printStackTrace();
        }
        criminalBaseService.addNew(criminalBase);
        return Result.ok();
    }
}
