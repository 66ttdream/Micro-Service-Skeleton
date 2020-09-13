package com.demo.chat.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author liuji
 * 预约信息
 */
@Data
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    private String id;
    private String name;
    @Column(name = "certificate_type")
    private String certificate_type;
    @Column(name = "certificate_number")
    private String certificate_number;
    @Column(name = "target_name")
    private String target_name;
    @Column(name = "certificate_time")
    private Date certificate_time;
    @Column(name = "relation")
    private String relation;
    @Column(name = "target_number")
    private String target_number;
    @Column(name = "meet_type")
    private String meet_type;
    @Column(name = "ispassed")
    private int isPassed;

}
