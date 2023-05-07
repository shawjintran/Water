package com.t.water.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.t.water.entity.Dev;
import com.t.water.service.DevService;
import com.t.water.utils.R;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dev")
@CrossOrigin
@Api("设备管理")
public class DevController {

    @Autowired
    private DevService devService;


    /**
     * 设备添加
     * @param managerId
     * @param id
     * @return
     */
    @GetMapping("add/{managerId}/{id}")
    public R addDev(@PathVariable String managerId,@PathVariable String id){
        Dev dev = new Dev();
        dev.setManagerId(managerId);
        dev.setId(id);
        if(devService.save(dev))
            return R.ok().message("添加设备成功");
        else
            return R.error().message("添加设备失败");

    }

    /**
     * 设备删除
     * @param devId
     * @return
     */
    @DeleteMapping("{devId}")
    public R  deleteDev(@PathVariable String devId){
        if(devService.removeById(devId))
            return R.ok().message("删除设备成功");
        else
            return R.error().message("删除设备失败");

    }

    /**
     * 通过管理者id获取设备列表
     * @param managerId
     * @return
     */
    @GetMapping("list/{managerId}")
    public R getDevlist(@PathVariable String managerId){
        QueryWrapper<Dev> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("manager_id",managerId);
        List<Dev> list = devService.list(queryWrapper);
        return R.ok().data("devList",list);


    }




}
