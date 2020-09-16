package com.demo.task.dao;

import com.demo.chat.po.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface TaskDao extends JpaRepository<Task,String> {

    public Iterable<Task> findByGroupId(String groupId);
    //@Transactional
    public void deleteByGroupId(String groupId);
}
