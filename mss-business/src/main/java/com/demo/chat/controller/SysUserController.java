package com.demo.chat.controller;


import com.demo.chat.service.SysUserService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sysuser")
@Api(tags = "系统用户api")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @GetMapping("all")
    public Result getAll(){
        return Result.ok(sysUserService.findAll());
    }
}
