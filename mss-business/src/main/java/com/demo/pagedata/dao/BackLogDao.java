package com.demo.pagedata.dao;

import com.demo.chat.po.BackLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BackLogDao extends JpaRepository<BackLog,String> {
    public Iterable<BackLog> findByUserName(String userName);
    //public void deleteByUserName(String name );
}
