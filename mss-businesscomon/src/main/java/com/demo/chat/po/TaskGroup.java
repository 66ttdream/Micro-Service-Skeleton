package com.demo.chat.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name="task_group")
public class TaskGroup {
    @Id
    private String group_id;
    private String group_name;
}
