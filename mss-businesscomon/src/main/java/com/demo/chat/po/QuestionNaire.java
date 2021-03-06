package com.demo.chat.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="questionnaire")
@ApiModel(description = "工作报告")
@NoArgsConstructor
@AllArgsConstructor
public class QuestionNaire {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String sjbh;
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date add_time;
    private String sjxz;
    private String fsdd;
    private String xgks;
    private String sjjg;
    private String cljg;
    private String jyzj;
    private String ldyj;
    private String file;
    @Column(name = "username")
    private String userName;
}
