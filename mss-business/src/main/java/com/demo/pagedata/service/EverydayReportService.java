package com.demo.pagedata.service;

import com.demo.chat.po.EverydayReport;
import com.demo.pagedata.dao.EverydayReportDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class EverydayReportService {
    @Resource
    private EverydayReportDao everydayReportDao;

    public List<EverydayReport> findByUser(String userName){
        if(userName.equals("admin")){
            return everydayReportDao.adminFind();
        }
        if(userName.equals("super")){
            return everydayReportDao.superFind();
        }else {
            return everydayReportDao.findAll();
        }
    }

    public void save(EverydayReport everydayReport){
        everydayReportDao.save(everydayReport);
    }

    public Optional<EverydayReport> findOne(String id){
        return everydayReportDao.findById(id);
    }

}
