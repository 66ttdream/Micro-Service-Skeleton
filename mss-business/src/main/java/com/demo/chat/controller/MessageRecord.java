package com.demo.chat.controller;

import com.demo.chat.po.Message;
import com.demo.chat.service.MessageService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/message")
@Api(tags = "即时聊天api")
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
    @ApiOperation(value = "用户获取未读消息条数总计")
    @GetMapping("unreadNum")
    @ApiImplicitParam(name="userName",value="用户名",required=true,dataType="String")
    public Result getUnreadCount(String userName){
        return Result.ok(messageService.findUnreadCount(userName));
    }

    @ApiOperation(value = "用户获取与指定用户的未读消息条数")
    @GetMapping("unreadOneByOne")
    @ApiImplicitParams({
            @ApiImplicitParam(name="sendName",value="发送消息用户名（账户主题）",required=true,dataType="String"),
            @ApiImplicitParam(name="acceptName",value="接收消息用户名",required=true,dataType="String")
    })
    public Result getUnreadOneByOne(String sendName,String acceptName){
        return Result.ok(messageService.findUnreadOneByOne(sendName,acceptName));
    }



}
