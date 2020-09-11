package com.demo.chat.controller;

import com.demo.chat.service.MessageService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/message")
public class MessageRecord {
    @Resource
    private MessageService messageService;
    @GetMapping("/accept_record")
    public Result findAcceptRecord(String username){
        return Result.ok(messageService.getMessagesByName(username));
    }
    @GetMapping (value = "/send_record")
    public Result findSendRecord(String username){
        return Result.ok(messageService.getMessagesBySendName(username));
    }
}
