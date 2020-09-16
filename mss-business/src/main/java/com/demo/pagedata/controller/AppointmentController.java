package com.demo.pagedata.controller;

import com.demo.chat.po.Appointment;
import com.demo.chat.util.UUID;
import com.demo.pagedata.service.AppointmentService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("appointment")
@Api(tags = "会见预约api")
public class AppointmentController {
    @Resource
    private AppointmentService appointmentService;

    @ApiOperation(value = "获取所有预约信息")
    @GetMapping("all")
    public Result getAll(){
        return Result.ok(appointmentService.findAll());
    }

    @ApiOperation(value = "保存/更新预约信息")
    @PostMapping("save")
    public  Result save(Appointment appointment){
        appointment.setAdd_time(new Date());
        Random random = new Random();
        int code = random.nextInt(99999999);
        appointment.setCode(String.valueOf(code));
        appointment.setId(UUID.getUUID());
        appointmentService.save(appointment);
        return Result.ok();
    }

}
