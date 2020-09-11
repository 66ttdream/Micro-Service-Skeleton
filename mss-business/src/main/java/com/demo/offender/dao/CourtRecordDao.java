package com.demo.offender.dao;

import com.demo.chat.po.CourtRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRecordDao extends JpaRepository<CourtRecord,String> {
}
