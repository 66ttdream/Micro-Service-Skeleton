package com.demo.offender.controller;

import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping("audio")
@Api(tags = "音频文件在线播放")
public class AudioController {

    @GetMapping("get")
    @ApiOperation(value = "获取音频文件流")
    @ApiImplicitParam(name="url",value="文件地址",required=true,dataType="String")
    public Result getAll(HttpServletRequest hreq, HttpServletResponse hres, String url){
        url = "127.0.0.1:8090"+url;
        try {
            URL redUrl = new URL(url);
            URLConnection urlConnection = redUrl.openConnection();
            urlConnection.setReadTimeout(9000);
            urlConnection.setConnectTimeout(9000);
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            String forMat = url.split("\\.")[1];
            if(forMat.equals("mp3")){
                hres.setHeader("Content-Type","audio/mpeg;charset=UTF-8");
            }
            IOUtils.copy(inputStream,hres.getOutputStream());
            hres.flushBuffer();
            return Result.ok();
        } catch (Exception e) {
           return Result.ok("出错，重试");
        }
    }
}
