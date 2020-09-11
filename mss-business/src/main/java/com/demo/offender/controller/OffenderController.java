package com.demo.offender.controller;

import com.demo.chat.po.PoliceRecord;
import com.demo.offender.service.OffenderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/offender")
public class OffenderController {
    @Resource
    private OffenderService offenderService;
    @GetMapping("/all")
    public Iterable<PoliceRecord> findAll(){
        return offenderService.getAllPoliceRecord();
    }
}
