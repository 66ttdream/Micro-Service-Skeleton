package com.demo.offender.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class QuestionChoiceDto {

    private String id;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String option5;

    private List<String> option6;

    private List<String>  option7;

    private List<String>  option8;

    private String appendix;

    private String appendix2;

    private String user;

    private Date submit_time;

}
