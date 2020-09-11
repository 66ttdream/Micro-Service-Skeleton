package com.demo.offender.controller;

import com.demo.chat.po.QuestionNaire;
import com.demo.offender.service.QuestionNaireService;
import org.springframework.web.bind.annotation.*;
import com.microservice.skeleton.common.vo.Result;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/questionnaire")
public class QuestionNaireController {
    @Resource
    private QuestionNaireService questionNaireService;

    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }*/


    @PostMapping("save")
    public Result save(QuestionNaire questionNaire){
        //System.out.println("系统时间..........................."+new Date());
        questionNaireService.save(questionNaire);
        return Result.ok("操作成功");
    }
    @GetMapping("theme")
    public Result getTheme(){
        List l =new ArrayList<String>();
        Iterator it = questionNaireService.getAll().iterator();
        while(it.hasNext()){
            QuestionNaire a = (QuestionNaire)it.next();
            String sjbh = a.getSjbh();
            l.add(sjbh);
        }
        return Result.ok(l);
    }
}
