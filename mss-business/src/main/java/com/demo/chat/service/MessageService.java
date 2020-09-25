package com.demo.chat.service;

import com.demo.chat.dao.MessageDao;
import com.demo.chat.po.Message;
import com.demo.chat.util.UUID;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageService {
    @Resource
    private MessageDao massageDao;
    public void save(Message message){
        message.setId(UUID.getUUID());
        massageDao.save(message);
    }
    public Iterable<Message> getMessagesByName(String username){
        return massageDao.findByAcceptName(username);
    }
    public Iterable<Message> getMessagesBySendName(String sendName){
        return massageDao.findBySendName(sendName);
    }


    public Iterable<Message> selectOneToOne(String sendName,String acceptName){
        return massageDao.findBySendNameAndAcceptName(sendName,acceptName);
    }
    public Iterable<Message> getMessageByAcceptName(String acceptName,String sendName){
        return massageDao.findByAcceptNameAndSendName(acceptName,sendName);
    }
    public long findUnreadCount(String userName){
        return massageDao.findUnreadCount(userName);
    }
    public long findUnreadOneByOne(String sendName,String acceptName){
        return massageDao.findUnreadOneByOne(sendName,acceptName);
    }
}
