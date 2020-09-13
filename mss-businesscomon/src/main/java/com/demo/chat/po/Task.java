package com.demo.chat.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name="task")
public class Task {
    @Id
    private String id;
    //private String group_name;
    @Column(name = "group_id")
    private String groupId;
    private String task_uri;
}
