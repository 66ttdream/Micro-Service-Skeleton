package com.demo.pagedata.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel(description = "流程统计返回对象")
@AllArgsConstructor
public class BackLogCount {
    @ApiModelProperty(value = "待办类型")
    private String activity_name;
    @ApiModelProperty(value = "类型个数")
    private long typeNumber;
}
