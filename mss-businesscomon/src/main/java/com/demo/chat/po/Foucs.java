package com.demo.chat.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "focus")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "重点关注")
public class Foucs {
    @Id
    @ApiModelProperty(value = "唯一主键")
    private String id;

    @ApiModelProperty(value = "用户名")
    @Column(name = "user_name")
    private String userName;

    @ApiModelProperty(value = "页面名称")
    private String page_name;

    @ApiModelProperty(value = "页面地址")
    private String page_uri;
}
