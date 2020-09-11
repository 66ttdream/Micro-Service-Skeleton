package com.demo.chat.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author liuji
 * @Deprecated 法院信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="court")
public class CourtRecord  {
    private String name;
    private String certificate_type;
    @Id
    private String certificate_number;
    private Date crime_date;
    private Date arrest_date;
    private Date sentence_date;
    private Date crime_fact;
    private String sentence_type;
    private String main_charges;
}
