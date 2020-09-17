package com.demo.pagedata.dao;

import com.demo.chat.po.Foucs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FocusDao extends JpaRepository<Foucs,String> {
    public Iterable<Foucs> findByUserName(String userName);

    @Transactional
    public void deleteByUserName(String userName);
    //public Iterable<Integer> findIdByName(String userName);
}
