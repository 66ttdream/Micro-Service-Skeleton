package com.demo.pagedata.dao;

import com.demo.chat.po.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDao extends JpaRepository<Appointment,String> {

}
