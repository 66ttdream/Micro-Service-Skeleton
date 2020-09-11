package com.demo.chat.po;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_user")
public class UserDto {
    @Id
    private String id;
    private String username;

}
