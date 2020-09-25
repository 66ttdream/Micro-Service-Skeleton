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
@Table(name = "sentiment")
@ApiModel(description = "舆情报告")
@Data
public class SentimentReport {
    @Id
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "报告时间")
    private String time;
    @ApiModelProperty(value = "事件主体")
    private String theme;
    @ApiModelProperty(value = "事件强度")
    private String strength;
    @ApiModelProperty(value = "发展趋势")
    private String tendency;
    @ApiModelProperty(value = "监狱形象")
    private String image;
    @ApiModelProperty(value = "事件摘要")
    private String abstracts;
    @ApiModelProperty(value = "相关科室")
    private String administrative;
    @ApiModelProperty(value = "发生日期")
    private String happen_time;
    @ApiModelProperty(value = "用户名")
    @Column(name = "username")
    private String userName;


}
