package com.demo.pagedata.controller;

import com.alibaba.fastjson.JSON;
import com.demo.pagedata.dto.SponsorSmsTemTemplate;
import com.demo.pagedata.service.SendSmsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:    短信
 * @Author:         Joe
 * @CreateDate:     2020/3/21 16:31
 */
@RestController
@RequestMapping("sms")
public class SmsController {


    @Resource
    private SendSmsUtil sendSmsUtil;

    @Value("${sms.templates}")
    private String[] templateCode;

    /**
     * 发送提醒消息
     * @param PhoneNumbers 手机号
     * @return
     */
    //@ResponseBody
    @RequestMapping(value = "send",method = RequestMethod.GET)
    public void sendSms(String PhoneNumbers) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String s1 = sdf.format(new Date());
        SponsorSmsTemTemplate s = new SponsorSmsTemTemplate(s1);
        String json = JSON.toJSONString(s);
        sendSmsUtil.aliSendSms(PhoneNumbers,json,templateCode[0]);
    }
}


