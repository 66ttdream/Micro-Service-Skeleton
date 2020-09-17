package com.demo.offender.dao;

import com.demo.chat.po.PoliceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PoliceRecordDao extends JpaRepository<PoliceRecord,String> {

    @Query("select p from PoliceRecord p order by p.add_time desc")
    public List<PoliceRecord> findAll();
}
