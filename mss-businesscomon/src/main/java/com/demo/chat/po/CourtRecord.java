package com.demo.chat.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author liuji
 * @Deprecated 法院信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="court")
@ApiModel(description = "法院人员信息")
public class CourtRecord  {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "证件类型")
    private String certificate_type;
    @Id
    @ApiModelProperty(value = "证件号码")
    private String certificate_number;

    @ApiModelProperty(value = "犯罪日期")
    private Date crime_date;

    @ApiModelProperty(value = "逮捕日期")
    private Date arrest_date;

    @ApiModelProperty(value = "判决日期")
    private Date sentence_date;

    @ApiModelProperty(value = "犯罪事实")
    private String crime_fact;
    @ApiModelProperty(value = "判决类型")
    private String sentence_type;
    @ApiModelProperty(value = "主罪名")
    private String main_charges;
}
