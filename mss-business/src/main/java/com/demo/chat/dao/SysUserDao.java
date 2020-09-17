package com.demo.chat.dao;

import com.demo.chat.po.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser, Integer> {
}
