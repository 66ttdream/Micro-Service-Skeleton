package com.demo.offender.controller;

import com.demo.offender.service.CourtRecordService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/personnelinfo")
public class PersonnelInfo {
    @Resource
    private CourtRecordService courtRecordService;

    //public void find
}
