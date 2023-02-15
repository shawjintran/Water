package com.t.water.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.t.water.entity.Manager;
import com.t.water.entity.Repair;
import com.t.water.entity.River;
import com.t.water.entity.vo.RiverQuery;
import com.t.water.service.ManagerService;
import com.t.water.service.RiverService;
import com.t.water.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/river")
@CrossOrigin
@Api(tags = "水域管理")
public class RiverController {
    @Autowired
    private RiverService riverService;

    @Autowired
    private ManagerService managerService;

    @ApiOperation(value="保存河流信息")
    @PostMapping
    public R addRiver(@RequestBody River river){
        if(riverService.save(river))
            return R.ok().message("保存成功");
        else
            return R.error().message("保存失败");
    }

    @ApiOperation(value="通过河长id获取水域信息")
    @GetMapping("get/{managerId}")
    public R getRiverById(@PathVariable String managerId){

        QueryWrapper<River> riverQueryWrapper = new QueryWrapper<>();
        riverQueryWrapper.eq("manager_id",managerId);
        River one = riverService.getOne(riverQueryWrapper);
        return R.ok().data("river",one);
    }



    @ApiOperation(value = "删除水域信息")
    @DeleteMapping("{riverId}")
    public R deleteRiver(@PathVariable String  riverId){
        boolean b = riverService.removeById(riverId);
        if(b)
            return R.ok().message("删除成功");
        else
            return R.error().message("删除失败");
    }

    @ApiOperation(value = "水域分页")
    @PostMapping("pageRiver/{current}/{limit}")
    public R pageManagerCondition(@PathVariable Long current,
                                  @PathVariable Long limit, @RequestBody(required = false) RiverQuery riverQuery) {
        Page<River> riverPage = new Page<>(current, limit);
        //构造条件
        QueryWrapper<River> riverQueryWrapper = new QueryWrapper<>();
        //通过河长名查河长id
        if(!StringUtils.isEmpty(riverQuery.getManagerName())){//如果值存在
            QueryWrapper<Manager> managerQueryWrapper = new QueryWrapper<>();
            managerQueryWrapper.like("name",riverQuery.getManagerName());//查相似河长名
            HashSet<String> managerIds=new HashSet<>();
            for (Manager manager : managerService.list(managerQueryWrapper)) {
                managerIds.add(manager.getId());
            }

            riverQueryWrapper.in("manager_id",managerIds);

        }
        if(!StringUtils.isEmpty(riverQuery.getRiverName())){
            riverQueryWrapper.like("name",riverQuery.getRiverName());
        }

        riverQueryWrapper.orderByAsc("name");//按照名字排序
        riverService.page(riverPage,riverQueryWrapper);
        long total = riverPage.getTotal();
        List<River> records = riverPage.getRecords();
        HashMap<String, Object> pageRiverList = new HashMap<>();
        pageRiverList.put("total",total);
        pageRiverList.put("rows",records);
        return R.ok().data("pageRiverList",pageRiverList);


    }


}