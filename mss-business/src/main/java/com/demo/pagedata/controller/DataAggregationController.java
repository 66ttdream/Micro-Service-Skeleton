package com.demo.pagedata.controller;

import com.demo.chat.po.DataAggregation;
import com.demo.chat.util.UUID;
import com.demo.offender.service.CriminalBaseService;
import com.demo.pagedata.service.DataAggregationService;
import com.microservice.skeleton.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;

@RestController
@RequestMapping("/dataAggregation")
@Api(tags = "数据汇集api")
public class DataAggregationController {
    @Resource
    private DataAggregationService dataAggregationService;

    @Resource
    private CriminalBaseService criminalBaseDaoService;


    @ApiOperation(value = "保存数据汇集数据")
    @PostMapping("/saveOne")
    public Result save(DataAggregation dataAggregation){
        if(dataAggregation.getId()==null){
            dataAggregation.setId(UUID.getUUID());
        }
        dataAggregationService.saveOne(dataAggregation);
        return Result.ok();
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "用户获取数据汇集数据")
    @ApiImplicitParam(name="userName",value="用户名（admin,test1,super）",required=true,dataType="String")
    public Result all(String userName){
        return Result.ok(dataAggregationService.getAll(userName));
    }

    @GetMapping("getone")
    @ApiOperation(value = "通过日期查询罪犯关押信息")
    @ApiImplicitParam(name="riqi",value="日期",required=true,dataType="String")
    public Result serach(String riqi) throws ParseException {
        //如果为空新增
        if(dataAggregationService.findByDate(riqi).isEmpty()){
            DataAggregation dataAggregation = new DataAggregation();
            long count = criminalBaseDaoService.findCount();
            dataAggregation.setCrimes_count((int)count);
            dataAggregation.setInmates((int)count);
            return Result.ok(dataAggregation);
        }else {
            //如果不为空，查询前一天数据，更新
            return Result.ok(dataAggregationService.findByDate(riqi));
        }
    }


}
