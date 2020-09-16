package com.demo.chat.po;

import com.sun.istack.internal.NotNull;
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
 * 预约信息
 */
@Data
@Entity
@Table(name = "appointment")
@ApiModel(description = "预约信息响应结果")
public class Appointment {

    @ApiModelProperty(value = "实体唯一主键")
    @Id
    private String id;

    @ApiModelProperty(value = "预约人姓名")
    private String name;

    @Column(name = "certificate_type")
    @ApiModelProperty(value = "证件类型")
    private String certificate_type;

    @ApiModelProperty(value = "证件编号")
    @Column(name = "certificate_number")
    private String certificate_number;

    @ApiModelProperty(value = "会见人姓名")
    @Column(name = "target_name")
    private String target_name;

    @ApiModelProperty(value = "会见时间")
    @Column(name = "certificate_time")
    private Date certificate_time;

    @ApiModelProperty(value = "与会见人关系")
    @Column(name = "relation")
    private String relation;

    @ApiModelProperty(value = "会见人编号")
    @Column(name = "target_number")
    private String target_number;

    @ApiModelProperty(value = "会见类型")
    @Column(name = "meet_type")
    private String meet_type;

    @ApiModelProperty(value = "是否通过（在审批是更新此字段:通过为1，不通过为0）")
    @Column(name = "ispassed")
    private String isPassed;

    @ApiModelProperty(value = "罪犯编号")
    @Column(name = "code")
    private String code;

    @ApiModelProperty(value = "添加时间")
    @Column(name = "add_time")
    private Date add_time;
}
