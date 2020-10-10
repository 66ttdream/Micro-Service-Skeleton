package com.demo.pagedata.service;

import com.demo.chat.po.DataAggregation;
import com.demo.pagedata.dao.DataAggregationDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DataAggregationService {
    @Resource
    private DataAggregationDao dataAggregationDao;
    public void saveOne(DataAggregation dataAggregation){
        dataAggregationDao.save(dataAggregation);
    }

    public List<DataAggregation> getAll(String userName){
        if(userName.equals("admin")){
            return dataAggregationDao.findAdminData("admin","test1");
        }
        if(userName.equals("super")){
            return dataAggregationDao.findSuperData("super");
        }
        if(userName.equals("test1")){
            return dataAggregationDao.findAll();
        }else {
            return null;
        }
    }

    public List<DataAggregation> findByDate(String date){
        return dataAggregationDao.findBydate(date);
    }

    public DataAggregation findOne(Date date){
        return dataAggregationDao.findByRiqi(date);
    }

}
