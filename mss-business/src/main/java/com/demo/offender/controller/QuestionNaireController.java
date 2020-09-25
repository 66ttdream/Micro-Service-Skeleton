package com.demo.offender.controller;

import com.demo.chat.po.QuestionNaire;
import com.demo.offender.service.QuestionNaireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.microservice.skeleton.common.vo.Result;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/questionnaire")
@Api(tags = "工作报告api")
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

    @GetMapping("all")
    @ApiOperation(value = "获取工作报告")
    @ApiImplicitParam(name="userName",value="用户名",required=true,dataType="String")
    public Result findByUser(String userName){
        return Result.ok(questionNaireService.findByUser(userName));
    }
    @GetMapping("one")
    @ApiOperation(value = "获取工作报告")
    @ApiImplicitParam(name="id",value="id",required=true,dataType="String")
    public Result findById(String id){
        return  Result.ok(questionNaireService.findById(id).get());
    }
}
