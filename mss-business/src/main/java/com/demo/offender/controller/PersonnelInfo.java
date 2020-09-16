package com.demo.offender.controller;

import com.demo.chat.po.CourtRecord;
import com.demo.chat.po.PoliceRecord;
import com.demo.offender.service.CourtRecordService;
import com.demo.offender.service.PoliceRecordService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/personnelinfo")
@Api(tags = "罪犯信息api")
public class PersonnelInfo {
    @Resource
    private CourtRecordService courtRecordService;

    @Resource
    private PoliceRecordService policeRecordService;

    @PostMapping("/save/court")
    @ApiOperation(value = "保存法院罪犯信息")
    public Result saveCourt(CourtRecord courtRecord){
        courtRecordService.save(courtRecord);
        return Result.ok("操作成功");
    }

    @ApiOperation(value = "保存公安罪犯信息")
    @PostMapping("/save/police")
    public Result savePolice(PoliceRecord policeRecord){
        policeRecordService.save(policeRecord);
        return Result.ok("操作成功");
    }

    @ApiOperation(value = "获取所有公安罪犯信息")
    @GetMapping("findall/police")
    public Result getAllPolice(){
        return Result.ok(policeRecordService.findAll());
    }

    @ApiOperation(value = "获取所有法院罪犯信息")
    @GetMapping("findallcourt")
    public Result getAllCourt(){
        return Result.ok(courtRecordService.findAll());
    }

    @ApiOperation(value = "获取法院指定罪犯信息")
    @GetMapping("/getone/court")
    @ApiImplicitParams(@ApiImplicitParam(name="certificate_number",value="证件编号",required=true))
    public Result getOneCourt(String certificate_number){
        return Result.ok(courtRecordService.findById(certificate_number));
    }

    @ApiOperation(value = "获取公安指定罪犯信息")
    @GetMapping("/getone/police")
    @ApiImplicitParams(@ApiImplicitParam(name="certificate_number",value="证件编号",required=true))
    public Result getOnePolice(String certificate_number){
        return Result.ok(policeRecordService.findById(certificate_number));
    }
}
