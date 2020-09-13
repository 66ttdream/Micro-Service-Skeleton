package com.demo.task.dao;

import com.demo.chat.po.PageConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageDao extends JpaRepository<PageConfig,String> {
}
