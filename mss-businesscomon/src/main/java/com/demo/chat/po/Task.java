package com.demo.chat.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="task")
@ApiModel("分组事务下的工作事项实体")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @ApiModelProperty(value = "唯一主键")
    private String id;
    //private String group_name;
    @ApiModelProperty(value = "组id")
    @Column(name = "group_id")
    private String groupId;

    @ApiModelProperty(value = "事项名称")
    private String taskName;

    @ApiModelProperty(value = "事项页面地址")
    private String task_uri;

    @ApiModelProperty(value = "url_name")
    private String url_name;

}
