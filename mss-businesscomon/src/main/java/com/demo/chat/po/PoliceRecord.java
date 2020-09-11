package com.demo.chat.po;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="police")
public class PoliceRecord  {
    private String name;
    private String certificate_type;
    @Id
    private String certificate_number;
    private Date crime_date;
    private Date custody_date;
    private Date arrest_date;
    private String after_profession;
    private String crime_fact;

}
