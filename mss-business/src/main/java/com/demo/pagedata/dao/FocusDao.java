package com.demo.pagedata.dao;

import com.demo.chat.po.Foucs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FocusDao extends JpaRepository<Foucs,String> {
    public Iterable<Foucs> findByUserName(String userName);
    public void deleteByUserName(String userName);
    //public Iterable<Integer> findIdByName(String userName);
}
