package com.demo.chat.po;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_aggregation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataAggregation {
    @Id
    private String id;
    //日期
    private String riqi;
    //押犯总数
    private Integer crimes_count;
    //在押人数
    private Integer inmates;
    //新收数
    private Integer new_add;
    //释放数
    private Integer release_number;
    //监外
    private Integer  jail_out;
    //监外住院
    private Integer hospitalized;
    //白班
    private Integer day_shift;
    //收封前
    private Integer after;
    //收封后
    private Integer later;
    //晚间
    private Integer night;

    //提交的用户
    private String userName;

}

