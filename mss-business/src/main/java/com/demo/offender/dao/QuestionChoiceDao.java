package com.demo.offender.dao;

import com.demo.chat.po.QuestionChoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionChoiceDao extends JpaRepository<QuestionChoice,String> {
}
