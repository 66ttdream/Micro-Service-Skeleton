package com.demo.offender.controller;

import com.demo.chat.po.CourtRecord;
import com.demo.chat.po.PoliceRecord;
import com.demo.offender.service.CourtRecordService;
import com.demo.offender.service.PoliceRecordService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/personnelinfo")
public class PersonnelInfo {
    @Resource
    private CourtRecordService courtRecordService;

    @Resource
    private PoliceRecordService policeRecordService;

    @PostMapping("/save/court")
    public Result saveCourt(CourtRecord courtRecord){
        return Result.ok("操作成功");
    }
    @PostMapping("/save/police")
    public Result savePolice(PoliceRecord policeRecord){
        policeRecordService.save(policeRecord);
        return Result.ok("操作成功");
    }

    @GetMapping("findall/police")
    public Result getAllPolice(){
        return Result.ok(policeRecordService.findAll());
    }
    @GetMapping("findallcourt")
    public Result getAllCourt(){
        return Result.ok(courtRecordService.findAll());
    }

    @GetMapping("/getone/court")
    public Result getOneCourt(String certificate_number){
        return Result.ok(courtRecordService.findById(certificate_number));
    }
    @GetMapping("/getone/police")
    public Result getOnePolice(String certificate_number){
        return Result.ok(policeRecordService.findById(certificate_number));
    }
}
