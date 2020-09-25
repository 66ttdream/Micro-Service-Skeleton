package com.demo.chat.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@ApiModel(description = "日常报告")
@Data
@Entity
@Table(name = "everyday")
public class EverydayReport {

    @Id
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "报告日期")
    private String report_date;
    @ApiModelProperty(value = "释放人数")
    private String release_num;
    @ApiModelProperty(value = "就医人数")
    private String ill_time;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "时长")
    private String duration;
    @ApiModelProperty(value = "次数")
    private String  frequency;
    @ApiModelProperty(value = "外协人员封闭")
    private String close;
    @ApiModelProperty(value = "外来车辆进出监")
    private String car;
    @ApiModelProperty(value = "用户")
    @Column(name = "username")
    private String userName;


}
