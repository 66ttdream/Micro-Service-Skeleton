package com.demo.chat.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="police")
@ApiModel(description = "法院记录信息")
public class PoliceRecord  {

    @ApiModelProperty(value = "罪犯名称")
    private String name;

    @ApiModelProperty(value = "证件类型")
    private String certificate_type;

    @ApiModelProperty(value = "证件编号")
    @Id
    private String certificate_number;

    @ApiModelProperty(value = "犯罪日期")
    private Date crime_date;

    @ApiModelProperty(value = "羁押日期")
    private Date custody_date;

    @ApiModelProperty(value = "逮捕日期")
    private Date arrest_date;

    @ApiModelProperty(value = "捕前职业")
    private String after_profession;

    @ApiModelProperty(value = "犯罪事实")
    private String crime_fact;

}
