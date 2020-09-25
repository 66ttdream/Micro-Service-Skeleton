package com.demo.pagedata.dao;

import com.demo.chat.po.SentimentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SentimentReportDao extends JpaRepository<SentimentReport,String> {

    @Query("select s from SentimentReport s where s.userName='admin' or  s.userName='super'")
    public List<SentimentReport> adminFindAll();

    @Query("select s from SentimentReport s where s.userName='super'")
    public List<SentimentReport> superFindAll();
}
