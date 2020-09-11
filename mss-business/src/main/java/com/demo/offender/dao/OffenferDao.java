package com.demo.offender.dao;

import com.demo.chat.po.PoliceRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffenferDao extends CrudRepository<PoliceRecord,String> {

}
