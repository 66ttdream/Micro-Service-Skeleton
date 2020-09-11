package com.demo.chat.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="")
public class Task {
    @Id
    private String task_id;
    private String task_name;
    private String task_url;
    private String task_type;
    private String group_id;
}
