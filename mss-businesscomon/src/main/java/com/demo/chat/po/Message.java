package com.demo.chat.po;

import com.demo.chat.vo.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author liuji
 * @Deprecated 消息实体
 */
@Data
@Entity
@Table(name = "message_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    //消息id
    private String id;
    //发送者
    @Column(name="sendname")
    private String sendName;
    //接收者
    @Column(name="acceptname")
    private String acceptName;
    //消息内容
    private String content_data;
    //产生时间
    private Date send_time;
    //消息类型,true为系统消息
    private String system_massage;
    //是否未读(未读为1，已读为0)
    private String isunread;
}
