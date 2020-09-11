package com.demo.chat.dao;

import com.demo.chat.po.Message;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository
public interface MessageDao extends JpaRepository<Message,String>{
    public Iterable<Message> findByAcceptName(String userName);
    public Iterable<Message> findBySendName(String sendName);
}
