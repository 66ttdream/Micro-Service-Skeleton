package com.demo.chat.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "questionchoice")
public class QuestionChoice {
    @Id
    private String id;
    @Column(name="option1")
    private String option1;
    @Column(name="option2")
    private String option2;
    @Column(name="option3")
    private String option3;
    @Column(name="option4")
    private String option4;
    @Column(name="appendix")
    private String appendix;
}
