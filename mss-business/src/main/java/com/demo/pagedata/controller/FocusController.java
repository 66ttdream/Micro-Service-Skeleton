package com.demo.pagedata.controller;

import com.demo.chat.po.Foucs;
import com.demo.chat.util.UUID;
import com.demo.pagedata.service.FocusService;
import com.microservice.skeleton.common.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/focus")
public class FocusController {
    @Resource
    private FocusService focusService;

    @PostMapping("/save")
    public Result save(@RequestBody List<Foucs> foucs){
        for(Foucs f:foucs){
            f.setId(UUID.getUUID());
            focusService.save(f);
        }
        return Result.ok();
    }

    @GetMapping("/get")
    public Result getByUserName(String user_name){
        return Result.ok(focusService.findByName(user_name));
    }

}
