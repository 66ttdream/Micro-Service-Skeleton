package com.demo.pagedata.service;


import com.demo.chat.po.ZeroReport;
import com.demo.pagedata.dao.ZeroReportDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ZeroReportService {

    @Resource
    private ZeroReportDao zeroReportDao;

    public List<ZeroReport> findByUser(String userName){
        if(userName.equals("admin")){
            return zeroReportDao.adminFind();
        }
        if(userName.equals("super")){
            return zeroReportDao.superFind();
        }
        else {
            return zeroReportDao.findAll();
        }
    }

    public void save(ZeroReport zeroReport){
        zeroReportDao.save(zeroReport);
    }

    public Optional<ZeroReport> findOne(String id){
        return zeroReportDao.findById(id);
    }
}
