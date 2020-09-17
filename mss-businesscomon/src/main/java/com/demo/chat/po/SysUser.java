package com.demo.chat.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_user")
@Data
@ApiModel(description = "系统用户信息")
public class SysUser {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "用户名")
    @Column(name = "username")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "盐")
    private String salt;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "性别：1男性，0女性")
    private int sex;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "电话号")
    private String phone;

    @ApiModelProperty(value = "状态")
    private String status;
    @ApiModelProperty(value = "创建日期")
    private String create_time;
    @ApiModelProperty(value = "更新日期")
    private String update_time;



}
