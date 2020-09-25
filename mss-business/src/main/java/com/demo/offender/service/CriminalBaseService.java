package com.demo.offender.service;

import com.demo.chat.po.CriminalBase;
import com.demo.offender.dao.CriminalBaseDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CriminalBaseService {
    @Resource
    private CriminalBaseDao criminalBaseDao;

    public void addNew(CriminalBase criminalBase){
        criminalBaseDao.save(criminalBase);
    }

    public void deleteOne(String id){
        criminalBaseDao.deleteById(id);
    }

    public Iterable<CriminalBase> findAll(){
        return criminalBaseDao.findAll();
    }

    public long findCount(){
        return criminalBaseDao.count();
    };
}
