package com.demo.chat.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="questionnaire")
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
}
