package com.demo.chat.po;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author liuji
 * 主页流程数据
 */
@Data
@Entity
@Table(name = "backlog")
public class BackLog {
    @Id
    private String id;

    private String userName;
    private String activity_name;
    private Date begin_time;
}
