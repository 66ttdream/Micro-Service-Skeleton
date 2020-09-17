package com.demo.chat.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "criminal_base")
@ApiModel(description = "罪犯基本信息")
public class CriminalBase {
    @Id
    @ApiModelProperty(value = "证件编号")
    private String certificate_number;

    @ApiModelProperty(value = "逮捕日期")
    private Date arrest_date;

    @ApiModelProperty(value = "证件类型")
    private String certificate_type;

    @ApiModelProperty(value = "犯罪日期")
    private Date crime_date;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "判决日期")
    private Date sentence_date;

    @ApiModelProperty(value = "捕前职业")
    private String after_job;

    @ApiModelProperty(value = "罪犯编号")
    private String offender_number;

    @ApiModelProperty(value = "羁押日期")
    private Date detain_date;

    @ApiModelProperty(value = "籍贯")
    @Column(name = "native_place")
    private String native_place;

    @ApiModelProperty(value = "犯罪地点")
    @Column(name = "venue")
    private String venue;

    @Column(name="add_date")
    @ApiModelProperty(value = "数据新增日期，不做显示")
    private Date add_date;
}
