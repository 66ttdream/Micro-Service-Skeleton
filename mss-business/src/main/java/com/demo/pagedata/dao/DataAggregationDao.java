package com.demo.pagedata.dao;

import com.demo.chat.po.DataAggregation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


public interface DataAggregationDao extends JpaRepository<DataAggregation,String> {

    @Transactional
    @Query("select d from DataAggregation d where d.userName=:admin or d.userName=:super")
    public List<DataAggregation> findAdminData(@Param("admin") String user1, @Param("super")String user2);


    @Query("select d from DataAggregation d where d.userName=:super")
    public List<DataAggregation> findSuperData(@Param("super")String user1);

    @Query("select d from DataAggregation d where d.riqi=:date")
    public List<DataAggregation> findBydate(@Param("date") String date);

    public DataAggregation findByRiqi(Date date);

}
