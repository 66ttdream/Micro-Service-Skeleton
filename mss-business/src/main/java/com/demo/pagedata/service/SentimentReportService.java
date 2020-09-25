package com.demo.pagedata.service;


import com.demo.chat.po.SentimentReport;
import com.demo.pagedata.dao.SentimentReportDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class SentimentReportService {

    @Resource
    private SentimentReportDao sentimentReportDao;
    public List<SentimentReport> findByUserName(String userName){
        if(userName.equals("admin")){
            return sentimentReportDao.adminFindAll();
        }
        if(userName.equals("super")){
            return sentimentReportDao.superFindAll();
        }
        else {
            return sentimentReportDao.findAll();
        }
    }

    public void save(SentimentReport sentimentReport){
        sentimentReportDao.save(sentimentReport);
    }

    public Optional<SentimentReport> fingOne(String id){
        return sentimentReportDao.findById(id);
    }
}
