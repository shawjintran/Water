package com.t.water.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.cj.x.protobuf.MysqlxExpect;
import com.t.water.entity.Sensor;
import com.t.water.entity.dto.PeriodOfTimeDto;
import com.t.water.service.SensorService;
import com.t.water.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
     * 查询现在开关是否打开
     */


    /**
     * 无
     * @param periodOfTimeDto
     * @return
     */
    @ApiOperation(value="查看一段时间的旧数据,还没写好")
    @PostMapping("olddata/{devId}")
    public R GetSensorOldDataById(@RequestBody PeriodOfTimeDto periodOfTimeDto,@PathVariable String devId ){

        log.info("时间"+periodOfTimeDto.toString());
        int HOUR=3600*1000;
        List<Sensor> averageList =new ArrayList<>();

        for (int i = 1; i < 24; i++) {
            QueryWrapper<Sensor> queryWrapper = new QueryWrapper<>();
            queryWrapper
                    .eq("dev_id",devId)
                    .le("created_time",new Date(periodOfTimeDto.getStartTime().getTime()+HOUR*(i-1)))
                    .ge("created_time",new Date(periodOfTimeDto.getStartTime().getTime()+HOUR*i));
            List<Sensor> list = sensorService.list(queryWrapper);
            Sensor sensor = averageCount(list);
            if(list.isEmpty()){//如果内容为空)
                sensor.initdemo(i+"",devId,new Date(periodOfTimeDto.getStartTime().getTime()+HOUR*i));
            }else{
            sensor.setCreatedTime(new Date(periodOfTimeDto.getStartTime().getTime()+HOUR*i));
            sensor.setUpdateTime(new Date(periodOfTimeDto.getStartTime().getTime()+HOUR*i));
            sensor.setId(""+i);
            sensor.setDevId(devId);
            sensor.setIsDeleted(0);
            sensor.setPumpStatus(1);
            sensor.setIsDeleted(0);
            System.out.println(sensor);
            }
            averageList.add(sensor);
        }
        return R.ok().data("list",averageList);
    }




    public Sensor averageCount(List<Sensor> list){

        Float turbidity = 0f;
        Float cod = 0f;
        Float tds = 0f;
        Float ph = 0f;
        Float temperature = 0f;

        for (Sensor sensor : list) {
            turbidity+=Float.valueOf(sensor.getTurbidity());
            cod+=Float.valueOf(sensor.getCod());
            tds+=Float.valueOf(sensor.getTds());
            ph+=Float.valueOf(sensor.getPh());
            temperature+=Float.valueOf(sensor.getTemperature());
            System.out.println("温度"+temperature);

        }

        Sensor averageList=new Sensor();
        averageList.setTurbidity(String.valueOf(turbidity/list.size()));
        averageList.setCod(String.valueOf(cod/list.size()));
        averageList.setTds(String.valueOf(tds/list.size()));
        averageList.setPh(String.valueOf(ph/list.size()));
        averageList.setTemperature((int) (temperature/list.size()));

        return averageList;
    }


}





























