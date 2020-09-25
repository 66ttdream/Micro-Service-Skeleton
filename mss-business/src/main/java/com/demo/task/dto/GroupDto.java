package com.demo.task.dto;


import com.demo.chat.po.Task;
import com.demo.chat.po.TaskGroup;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(description = "事务组传输对象")
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {
    private String id;
    private String name;
    private String groupId;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd HH:mm:ss")
    private Date deadline;
    private String userName;
    private String warningTime;
    private String cycle;
    private List<Task> tasks;
    public TaskGroup getTaskGroup(){
        return TaskGroup.builder()
                .id(this.id)
                .name(this.name)
                .deadline(this.deadline)
                .userName(this.userName)
                .warningTime(this.warningTime)
                .cycle(this.cycle)
                .build();
    }
}
