package com.demo.offender.service;

import com.demo.chat.po.QuestionNaire;
import com.demo.offender.dao.QuestionNaireDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class QuestionNaireService {
    @Resource
    private QuestionNaireDao questionNaireDao;

    @Transactional
     public void save(QuestionNaire questionNaire){
         questionNaireDao.save(questionNaire);
     }

     public Iterable<QuestionNaire> findByUser(String userName){

         if(userName.equals("admin")){
             return questionNaireDao.adminFind();
         }
         if(userName.equals("super")){
             return questionNaireDao.superFind();
         }else {
             return questionNaireDao.findAll();
         }
     }
    public Iterable<QuestionNaire> getAll(){
        return questionNaireDao.findAll();
    }

    public Optional<QuestionNaire> findById(String id){
       return questionNaireDao.findById(id);
    }
}
