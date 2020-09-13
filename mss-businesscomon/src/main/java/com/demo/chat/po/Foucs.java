package com.demo.chat.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "focus")
@NoArgsConstructor
@AllArgsConstructor
public class Foucs {
    @Id
    private String id;
    @Column(name = "user_name")
    private String userName;
    private String page_name;
    private String page_uri;
}
