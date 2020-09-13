package com.demo.chat.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="taskgroup")
public class TaskGroup {
    @Id
    private String id;
    private String name;
    @Column(name = "groupid")
    private String groupId;
    @Column(name = "deadline")
    private String deadline;
    @Column(name = "username")
    private String userName;
    @Column(name = "warningtime")
    private String warningTime;
}
