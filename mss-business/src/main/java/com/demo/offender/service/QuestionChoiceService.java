package com.demo.offender.service;

import com.demo.offender.dao.QuestionChoiceDao;
import com.demo.chat.po.QuestionChoice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuestionChoiceService {
    @Resource
    private QuestionChoiceDao questionChoiceDao;
    public void save(QuestionChoice questionChoice){
        questionChoiceDao.save(questionChoice);
    }
    public Iterable<QuestionChoice> findAll(){
        return questionChoiceDao.findAll();
    }
}
