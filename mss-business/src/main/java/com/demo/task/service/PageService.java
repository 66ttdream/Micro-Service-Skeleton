package com.demo.task.service;


import com.demo.chat.po.PageConfig;
import com.demo.task.dao.PageDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PageService {
    @Resource
    private PageDao pageDao;

    public void save(PageConfig pageConfig){
        pageDao.save(pageConfig);
    }

    public void deleteById(String pageId){
        pageDao.deleteById(pageId);
    }
    public Iterable<PageConfig> findAll(){
        return pageDao.findAll();
    }
}
