package com.demo.task.controller;


import com.demo.chat.po.PageConfig;
import com.demo.chat.util.UUID;
import com.demo.task.service.PageService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("page")
@Api(tags = "页面配置api")
public class PageController {
    @Resource
    private PageService pageService;


    @PostMapping("save")
    @ApiOperation(value = "保存单个页面配置")
    public Result savePage(PageConfig pageConfig){
        pageConfig.setId(UUID.getUUID());
        pageService.save(pageConfig);
        return Result.ok();
    }
    @GetMapping("delete")
    @ApiImplicitParams(@ApiImplicitParam(name="id",value="页面id",required=true))
    public Result delete(String id){
        pageService.deleteById(id);
        return Result.ok();
    }

    @ApiOperation(value = "获取所有页面信息")
    @GetMapping("all")
    public Result findAll(){
        return Result.ok(pageService.findAll());
    }

}
