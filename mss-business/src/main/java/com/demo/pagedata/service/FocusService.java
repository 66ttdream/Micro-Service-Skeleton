package com.demo.pagedata.service;

import com.demo.chat.po.Foucs;
import com.demo.pagedata.dao.FocusDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FocusService {
    @Resource
    private FocusDao focusDao;

    public void save(Foucs foucs){
        focusDao.save(foucs);
    }
    public void delete(String id){
        focusDao.deleteById(id);
    }
    public Iterable<Foucs> findByName(String userName){
        return focusDao.findByUserName(userName);
    }
}
