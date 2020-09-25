package com.demo.pagedata.dao;

import com.demo.chat.po.Cron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CronDao extends  JpaRepository<Cron,String>{

    /*@Query("select NEW com.demo.pagedata.dto.BackLogMassageDto(c.group_name,c.task_count) from Cron c")
    public List<BackLogMassageDto> findMessage();*/
    @Transactional
    @Modifying
    @Query(value = "delete from Cron c where c.id=?1")
    public void deleteCronByGroup_id(String Group_id);

}
