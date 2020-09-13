package com.demo.pagedata.controller;

import com.demo.chat.po.Appointment;
import com.demo.chat.util.UUID;
import com.demo.pagedata.service.AppointmentService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
    @Resource
    private AppointmentService appointmentService;

    @GetMapping("all")
    public Result getAll(){
        return Result.ok(appointmentService.findAll());
    }

    @PostMapping("save")
    public  Result save(Appointment appointment){
        appointment.setId(UUID.getUUID());
        appointmentService.save(appointment);
        return Result.ok();
    }

}
