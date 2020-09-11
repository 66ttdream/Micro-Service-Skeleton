package com.demo.offender.service;

import com.demo.chat.po.PoliceRecord;
import com.demo.offender.dao.OffenferDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class OffenderService{
    @Resource
    private OffenferDao offenferDao;
    public Iterable<PoliceRecord> getAllPoliceRecord(){
        return offenferDao.findAll();
    }
}
