package com.demo.chat.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cron")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cron {
    @Id
    private String id;
    private String group_name;
    private String group_id;
    private String user_name;
    private String cron;
    private Integer task_count;
}
