package com.demo.offender.service;

import com.demo.chat.po.FileInfo;
import com.demo.offender.dao.FileInfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class FileInfoService {
    @Resource
    private FileInfoDao fileInfoDao;

    //@Transactional
    public Optional<FileInfo> findById(String id){
        return fileInfoDao.findById(id);
    }

    @Transactional
    public void saveFileInfo(FileInfo fi){
        fileInfoDao.save(fi);
    }
}
