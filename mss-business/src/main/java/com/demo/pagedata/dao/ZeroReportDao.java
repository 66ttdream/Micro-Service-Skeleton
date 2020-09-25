package com.demo.pagedata.dao;

import com.demo.chat.po.ZeroReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ZeroReportDao extends JpaRepository<ZeroReport,String> {

    @Query("select z from ZeroReport z where z.userName='admin' or z.userName='super'")
    public List<ZeroReport> adminFind();
    @Query("select z from ZeroReport z where z.userName='super'")
    public List<ZeroReport> superFind();
}
