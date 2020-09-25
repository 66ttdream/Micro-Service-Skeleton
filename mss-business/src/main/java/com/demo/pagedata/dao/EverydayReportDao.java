package com.demo.pagedata.dao;

import com.demo.chat.po.EverydayReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EverydayReportDao extends JpaRepository<EverydayReport,String > {
    @Query("select e from EverydayReport e where e.userName='admin' or e.userName='super'")
    public List<EverydayReport> adminFind();


    @Query("select e from EverydayReport e where e.userName='super'")
    public List<EverydayReport> superFind();

}
