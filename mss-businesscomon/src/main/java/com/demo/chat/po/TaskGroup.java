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
@Table(name="taskgroup")
@ApiModel("任务组")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskGroup {
    @Id
    @ApiModelProperty(value = "唯一主键")
    private String id;

    @ApiModelProperty(value = "组名称")
    private String name;

    @ApiModelProperty(value = "完成时间")
    @Column(name = "deadline")
    private Date deadline;

    @ApiModelProperty(value = "任务组所属用户")
    @Column(name = "username")
    private String userName;

    @ApiModelProperty(value = "体系时间")
    @Column(name = "warningtime")
    private String warningTime;

    @ApiModelProperty(value = "事务提醒类型")
    private String cycle;
}
