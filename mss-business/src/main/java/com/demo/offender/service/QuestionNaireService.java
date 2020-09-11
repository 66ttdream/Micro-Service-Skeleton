package com.demo.offender.service;

import com.demo.chat.po.QuestionNaire;
import com.demo.offender.dao.QuestionNaireDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;

@Service
public class QuestionNaireService {
    @Resource
    private QuestionNaireDao questionNaireDao;

    @Transactional
     public void save(QuestionNaire questionNaire){
         questionNaireDao.save(questionNaire);
     }

     public Iterable<QuestionNaire> getAll(){
         return questionNaireDao.findAll();
     }
}
