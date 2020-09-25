package com.demo.pagedata.dao;

import com.demo.chat.po.BackLog;
import com.demo.pagedata.dto.BackLogCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BackLogDao extends JpaRepository<BackLog,String> {
    @Query("select b from BackLog b where b.userName=:userName and b.activity_name=:activity_name")
    public Iterable<BackLog> findByUserNameAndActivity_name(@Param("userName") String userName,@Param("activity_name") String activity_name);
    //public void deleteByUserName(String name );
    //获取代办事项种类及条数
    @Query("SELECT new com.demo.pagedata.dto.BackLogCount(b.activity_name,COUNT(b.activity_name)) FROM BackLog b where b.userName=:userName GROUP BY b.activity_name")
    public List<BackLogCount> findTypeAnCount(@Param("userName") String userName);
}
