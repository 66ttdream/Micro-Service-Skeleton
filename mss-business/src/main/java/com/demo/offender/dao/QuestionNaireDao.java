package com.demo.offender.dao;

import com.demo.chat.po.QuestionNaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionNaireDao extends CrudRepository<QuestionNaire,String> {
}
