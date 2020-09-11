package com.demo.offender.service;

import com.demo.chat.po.PoliceRecord;
import com.demo.offender.dao.PoliceRecordDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class PoliceRecordService {
    @Resource
    private PoliceRecordDao policeRecordDao;
    public void save(PoliceRecord policeRecord){
        policeRecordDao.save(policeRecord);
    }
    public Iterable<PoliceRecord> findAll(){
        return policeRecordDao.findAll();
    }

    public Optional<PoliceRecord> findById(String id){
        return policeRecordDao.findById(id);
    }
}
