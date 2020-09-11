package com.demo.offender.dao;

import com.demo.chat.po.PoliceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliceRecordDao extends JpaRepository<PoliceRecord,String> {
}
