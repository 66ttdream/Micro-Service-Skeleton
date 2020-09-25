package com.demo.pagedata.dao;

import com.demo.chat.po.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentDao extends JpaRepository<Appointment,String> {

    @Query("select x from Appointment x order by x.add_time DESC")
    public List<Appointment> findAll();

    @Query("select count(a.id) from Appointment a")
    public long count();

}
