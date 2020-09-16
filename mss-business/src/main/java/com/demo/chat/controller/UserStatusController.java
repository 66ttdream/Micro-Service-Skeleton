package com.demo.chat.controller;

import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "聊天用户api")
public class UserStatusController {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @ApiOperation(value = "获取所有在线用户名")
    @GetMapping("/online")
    public Result getStatus(){
        Long size = redisTemplate.opsForList().size("online");
        List<String> list = redisTemplate.opsForList().range("online", 0, size);
        //String s = redisTemplate.opsForValue().get("online");
        return Result.ok(list);
    }
}
