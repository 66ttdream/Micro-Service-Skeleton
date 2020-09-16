package com.demo.chat.dao;

import com.demo.chat.po.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


//@Repository
public interface MessageDao extends JpaRepository<Message,String>{
    public Iterable<Message> findByAcceptName(String userName);
    public Iterable<Message> findBySendName(String sendName);
    @Query("select m from Message m where (m.acceptName=:userName and m.sendName=:sendName ) or (m.acceptName=:sendName and m.sendName=:userName ) order by m.send_time")
    //@Query("select m from Message m where m.sendName=:sendName and m.acceptName=:userName order by m.send_time")
    public Iterable<Message> findBySendNameAndAcceptName(@Param("sendName") String sendName, @Param("userName") String userName);

    @Query("select m from Message m where (m.acceptName=:userName and m.sendName=:sendName ) and (m.acceptName=:sendName and m.sendName=:userName ) order by m.send_time")
    public Iterable<Message> findByAcceptNameAndSendName(@Param("userName") String sendName, @Param("sendName") String userName);
}
