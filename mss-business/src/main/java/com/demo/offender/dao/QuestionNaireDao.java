package com.demo.offender.dao;

import com.demo.chat.po.QuestionNaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionNaireDao extends CrudRepository<QuestionNaire,String> {
    @Query("select q from QuestionNaire q where q.userName='admin' or q.userName='super'")
    public List<QuestionNaire> adminFind();

    @Query("select q from QuestionNaire q where q.userName='super'")
    public List<QuestionNaire> superFind();

}
