package com.demo.chat.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "questionchoice")
@ApiModel(description = "选项调查表")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionChoice {
    @Id
    @ApiModelProperty(value = "唯一主键")
    private String id;

    @ApiModelProperty(value = "选项一")
    @Column(name="option1")
    private String option1;

    @ApiModelProperty(value = "选项2")
    @Column(name="option2")
    private String option2;

    @ApiModelProperty(value = "选项3")
    @Column(name="option3")
    private String option3;

    @ApiModelProperty(value = "选项4")
    @Column(name="option4")
    private String option4;

    @ApiModelProperty(value = "选项5")
    @Column(name="option5")
    private String option5;

    @ApiModelProperty(value = "选项6")
    @Column(name="option6")
    private String option6;

    @ApiModelProperty(value = "选项7")
    @Column(name="option7")
    private String option7;

    @ApiModelProperty(value = "选项8")
    @Column(name="option8")
    private String option8;

    @ApiModelProperty(value = "内容1")
    @Column(name="appendix")
    private String appendix;

    @ApiModelProperty(value = "内容2")
    @Column(name="appendix2")
    private String appendix2;

    @ApiModelProperty(value = "提交者")
    @Column(name="user_name")
    private String user;

    @ApiModelProperty(value = "提交时间")
    private Date submit_time;
    @ApiModelProperty(value = "文件下载地址")
    private String path;


}
