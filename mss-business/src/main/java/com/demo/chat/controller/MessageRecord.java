package com.demo.chat.controller;

import com.demo.chat.po.Message;
import com.demo.chat.service.MessageService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @GetMapping(value = "onetoone")
    public Result findOneToOne(String sendName,String acceptName){
        List<Message> l = new ArrayList<>();
        Iterable<Message> it = messageService.selectOneToOne(sendName,acceptName);
        //Iterable<Message> it2 = messageService.getMessageByAcceptName(acceptName,sendName);
        //Iterable<Message> it2 = messageService.selectOneToOne(acceptName,sendName);
        Iterator i = it.iterator();
        //Iterator i2 = it2.iterator();

        while (i.hasNext()){
            Message msg = (Message) i.next();
            l.add(msg);
        }
        /*while (i2.hasNext()){
            Message msg = (Message) i2.next();
            l.add(msg);
        }*/

        return Result.ok(it);
    }

}
