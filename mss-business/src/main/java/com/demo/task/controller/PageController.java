package com.demo.task.controller;


import com.demo.chat.po.PageConfig;
import com.demo.chat.util.UUID;
import com.demo.task.service.PageService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("page")
public class PageController {
    @Resource
    private PageService pageService;

    @PostMapping("save")
    public Result savePage(PageConfig pageConfig){
        pageConfig.setId(UUID.getUUID());
        pageService.save(pageConfig);
        return Result.ok();
    }
    @GetMapping("delete")
    public Result delete(String id){
        pageService.deleteById(id);
        return Result.ok();
    }
    @GetMapping("all")
    public Result findAll(){
        return Result.ok(pageService.findAll());
    }

}
