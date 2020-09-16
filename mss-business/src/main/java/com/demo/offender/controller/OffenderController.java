package com.demo.offender.controller;

import com.demo.chat.po.PoliceRecord;
import com.demo.offender.service.OffenderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/offender")
//@Api(tags = "法院罪犯信息api")
public class OffenderController {
    @Resource
    private OffenderService offenderService;
    @GetMapping("/all")
    //@ApiOperation(value = "获取所有罪犯信息")
    public Iterable<PoliceRecord> findAll(){
        return offenderService.getAllPoliceRecord();
    }
}
