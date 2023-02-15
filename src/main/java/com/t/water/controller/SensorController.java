package com.t.water.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.t.water.entity.Sensor;
import com.t.water.entity.dto.PeriodOfTimeDto;
import com.t.water.service.SensorService;
import com.t.water.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sensor")
@CrossOrigin
@Api(tags = "传感器信息管理")
public class SensorController {


    @Autowired
    private SensorService sensorService;

    /**
     *
     * @param devId
     * @return
     */

    @ApiOperation(value="获取该传感器的前num个数据")
    @GetMapping("{devId}/{num}")
    public R GetSensorById(@PathVariable String devId,@PathVariable Integer num ){
        QueryWrapper<Sensor> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("dev_id",devId);
        queryWrapper.orderByDesc("update_time");
        queryWrapper.last("limit "+num);//获取前num个
        List<Sensor> list = sensorService.list(queryWrapper);
        return R.ok().data("sensorList",list);
    }


    /**
     * 无
     * @param periodOfTimeDto
     * @return
     */
    @ApiOperation(value="查看一段时间的旧数据,还没写好")
    @PostMapping("olddata")
    public R GetSensorOldDataById(@RequestBody PeriodOfTimeDto periodOfTimeDto){

        log.info(periodOfTimeDto.toString());

        return R.ok();
    }



}





























