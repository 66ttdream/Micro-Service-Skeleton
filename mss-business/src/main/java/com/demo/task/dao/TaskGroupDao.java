package com.demo.task.dao;

import com.demo.chat.po.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskGroupDao extends JpaRepository<TaskGroup,String> {
}
