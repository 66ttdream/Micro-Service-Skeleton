package com.demo.offender.dao;

import com.demo.chat.po.CriminalBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CriminalBaseDao extends JpaRepository<CriminalBase,String> {

    @Query("select m from CriminalBase m order by m.add_date ASC")
    public List<CriminalBase> findAll();

}
