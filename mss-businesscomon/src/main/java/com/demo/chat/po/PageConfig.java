package com.demo.chat.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author liuji
 * 页面配置类
 */
@Data
@Entity
@Table(name = "page")
public class PageConfig {
    @Id
    private String id;
    @Column(name = "page_name")
    private String pageName;
    @Column(name = "page_uri")
    private String pageUri;
}
