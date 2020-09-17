package com.demo.chat.service;

import com.demo.chat.dao.SysUserDao;
import com.demo.chat.po.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    public Iterable<SysUser> findAll(){
        return sysUserDao.findAll();
    }
}
