package com.demo.chat.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "主页流程数据")
public class BackLog {
    @Id
    @ApiModelProperty(value = "唯一主键")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "流程名")
    private String activity_name;

    @ApiModelProperty(value = "开始时间")
    private Date begin_time;
}
