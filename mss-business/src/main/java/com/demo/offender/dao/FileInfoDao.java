package com.demo.offender.dao;

import com.demo.chat.po.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface FileInfoDao extends JpaRepository<FileInfo,String> {
    //public FileInfo findById(String id);
}
