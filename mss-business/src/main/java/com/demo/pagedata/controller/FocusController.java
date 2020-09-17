package com.demo.pagedata.controller;

import com.demo.chat.po.Foucs;
import com.demo.chat.util.UUID;
import com.demo.pagedata.service.FocusService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.TransactionRequiredException;
import java.util.List;

@RestController
@RequestMapping("/focus")
@Api(tags = "重点关注api")
public class FocusController {
    @Resource
    private FocusService focusService;

    @ApiOperation(value = "保存重点关注数据")
    @PostMapping("/save")
    public Result save(@RequestBody List<Foucs> foucs){
        String userName = foucs.get(0).getUserName();
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss:"+userName);
        //Iterable<Integer> ids = focusService.findIdByName(userName);

        try {
            focusService.deleteByName(userName);
        }catch (RuntimeException e){
            return Result.ok();
        }finally {
            for(Foucs f:foucs){
                f.setId(UUID.getUUID());
                focusService.save(f);
            }
        }
        return Result.ok();
    }


    @ApiOperation(value = "用户获取重点关注数据")
    @GetMapping("/get")
    @ApiImplicitParams(@ApiImplicitParam(name="user_name",value="用户名",required=true))
    public Result getByUserName(String user_name){
        return Result.ok(focusService.findByName(user_name));
    }

}
