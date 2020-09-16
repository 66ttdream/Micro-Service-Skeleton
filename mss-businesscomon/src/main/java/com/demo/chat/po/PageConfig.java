package com.demo.chat.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author liuji
 * 页面配置类
 */
@Data
@Entity
@Table(name = "page")
@ApiModel(description = "页面信息")
public class PageConfig {
    @Id
    @ApiModelProperty(value = "唯一主键")
    private String id;

    @ApiModelProperty(value = "页面名称")
    @Column(name = "page_name")
    private String pageName;

    @ApiModelProperty(value = "页面地址")
    @Column(name = "page_uri")
    private String pageUri;
}
