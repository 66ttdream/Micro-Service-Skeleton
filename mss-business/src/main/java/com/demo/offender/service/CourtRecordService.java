package com.demo.offender.service;

import com.demo.chat.po.CourtRecord;
import com.demo.offender.dao.CourtRecordDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CourtRecordService {
    @Resource
    private CourtRecordDao courtRecordDao;
    public void save(CourtRecord courtRecord){
        courtRecordDao.save(courtRecord);
    }
    public Iterable<CourtRecord> findAll(){
        return courtRecordDao.findAll();
    }
    public Optional<CourtRecord> findById(String id){
        return courtRecordDao.findById(id);
    }
}
