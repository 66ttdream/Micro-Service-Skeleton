package com.demo.pagedata.service;

import com.demo.chat.po.Appointment;
import com.demo.pagedata.dao.AppointmentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AppointmentService {
    @Resource
    private AppointmentDao appointmentDao;

    public void save(Appointment appointment){
        appointmentDao.save(appointment);
    }

    public Iterable<Appointment> findAll(){
        return appointmentDao.findAll();
    }
}
