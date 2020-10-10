package com.demo.pagedata.controller;

import com.alibaba.fastjson.JSON;
import com.demo.chat.controller.ChatController;
import com.demo.chat.po.Appointment;
import com.demo.chat.util.UUID;
import com.demo.pagedata.dto.MeetResponseTemplate;
import com.demo.pagedata.dto.SponsorSmsTemTemplate;
import com.demo.pagedata.service.AppointmentService;
import com.demo.pagedata.service.SendSmsUtil;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("appointment")
@Api(tags = "会见预约api")
public class AppointmentController {
    @Resource
    private AppointmentService appointmentService;

    @Resource
    private SendSmsUtil sendSmsUtil;

    @Value("${sms.templates}")
    private String[] templates;


    @ApiOperation(value = "获取所有预约信息")
    @GetMapping("all")
    public Result getAll(){
        return Result.ok(appointmentService.findAll());
    }

    @ApiOperation(value = "保存/更新预约信息")
    @PostMapping("save")
    public  Result save(Appointment appointment) throws IOException {
        String id = UUID.getUUID();
        appointment.setAdd_time(new Date());
        Random random = new Random();
        int code = random.nextInt(99999999);
        appointment.setCode(String.valueOf(code));
        appointment.setId(id);
        appointmentService.save(appointment);
        if(appointment.getIsPassed()!=null){
            //发消息，成功：提醒什么时候关注消息，失败：提醒重新提交
            if(appointment.getIsPassed().equals("1")){

                sendSmsUtil.aliSendSms(appointment.getPhoneNumber(),null,templates[1]);
            }else if(appointment.getIsPassed().equals("0")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                String date = sdf.format(appointment.getCertificate_time());
                MeetResponseTemplate s = new MeetResponseTemplate(date,"xxxxx");
                String json = JSON.toJSONString(s);
                sendSmsUtil.aliSendSms(appointment.getPhoneNumber(),json,templates[2]);
                }
        }
        if(appointment.getIsPassed()==null){
            sendSmsUtil.aliSendSms(appointment.getPhoneNumber(),null,templates[0]);
            ChatController.sendInfo("id","admin");
            ChatController.sendInfo("id","super");
            ChatController.sendInfo("id","test1");
        }
        return Result.ok();
    }

}
