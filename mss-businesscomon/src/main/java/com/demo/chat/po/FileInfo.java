package com.demo.chat.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@Data
@Table(name="file_info")
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    @Id
    private String id;
    @Column(name = "file_name")
    private String file_name;
    //private String file_code;

}
