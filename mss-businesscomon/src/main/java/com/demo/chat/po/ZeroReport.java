package com.demo.chat.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Zero")
@ApiModel(description = "零报告实体")
@Data
public class ZeroReport {
    @Id
    @ApiModelProperty(value = "唯一主键")
    private String id;

    @ApiModelProperty(value = "报告日期")
    @Column(name = "reporttime")
    private String reportTime;
    @ApiModelProperty(value = "安全事故数")
    private String number;
    @ApiModelProperty(value = "省局通报数")
    private String broadcast;
    @ApiModelProperty(value = "监狱通报数")
    private String p_broadcast;
    @ApiModelProperty(value = "指挥中心提醒问题")
    private String remind;
    @ApiModelProperty(value = "用户名")
    private String userName;


}
