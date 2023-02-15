package com.t.water.controller;


import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.t.water.entity.Manager;
import com.t.water.entity.Repair;
import com.t.water.entity.vo.RepairQuery;
import com.t.water.service.ManagerService;
import com.t.water.service.RepairService;
import com.t.water.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/repair")
@CrossOrigin
@Api(tags = "保修管理")
public class RepairController {

    @Autowired
    private RepairService repairService;


    @Autowired
    private ManagerService managerService;

    /**
     * 维修分页
     * @param current
     * @param limit
     * @param repairQuery
     * @return
     */
    @ApiOperation(value="维修查询分页")
    @GetMapping("pageRepair/{current}/{limit}")
    public R pageManagerCondition(@PathVariable Long current,
                                  @PathVariable Long limit,
                                  @RequestBody(required = false) RepairQuery repairQuery) {
        Page<Repair> repairPage = new Page<>(current, limit);

        //构造条件
        QueryWrapper<Repair> repairQueryWrapper=new QueryWrapper<>();
        //通过河长名查河长id
        if(!StringUtils.isEmpty(repairQuery.getManagerName())) {
            QueryWrapper<Manager> managerQueryWrapper = new QueryWrapper<>();
            managerQueryWrapper.like("name", repairQuery.getManagerName());//查相似名字
            //建立一个hashset存id
            //使用hashset进行减重
            HashSet<String> managerIds = new HashSet<>();
            for (Manager manager : managerService.list(managerQueryWrapper)) {
                managerIds.add(manager.getId());
            }

            repairQueryWrapper.in("manager_id",managerIds);
        }
        if(!StringUtils.isEmpty(repairQuery.getProgressWords())){
            repairQueryWrapper.like("repair_description",repairQuery.getProgressWords());
        }
        repairQueryWrapper.orderByAsc("update_time");//按照时间降序排序
        repairService.page(repairPage,repairQueryWrapper);
        long total = repairPage.getTotal();//获取命中总数
        List<Repair> records = repairPage.getRecords();
        HashMap<String,Object> pageRepairList = new HashMap<>();
        pageRepairList.put("total",total);
        pageRepairList.put("rows",records);
        return R.ok().data("pageRepairList",pageRepairList);
    }


    //维修申请
    @ApiOperation(value="申请维修")
    @PostMapping("add")
    public R addRepair (@RequestBody Repair repair){
        boolean save = repairService.save(repair);
        if(save)
            return R.ok().message("申请成功,请等待维修");
        else
            return R.error().message("申请失败");
    }



    //维修信息修改
    @ApiOperation("维修描述信息修改")
    @PostMapping("description/{description}/{repairId}")
    public R updateRepair(@PathVariable String description,@PathVariable String repairId ){

        Repair repairServiceById = repairService.getById(repairId);
        repairServiceById.setRepairDescription(description);
        boolean save = repairService.save(repairServiceById);
        if(save)
            return R.ok().message("维修描述修改成功");
        else
            return R.error().message("维修描述修改失败");

    }
    //河长维修记录全删除
    @ApiOperation("河长维修记录全删除")
    @DeleteMapping("all/{managerId}")
    public R deleteAllRepairByManagerId(@PathVariable String managerId){
        QueryWrapper<Repair> repairQueryWrapper = new QueryWrapper<>();
        repairQueryWrapper.eq("manager_id",managerId);
        boolean remove = repairService.remove(repairQueryWrapper);
        if(remove)
            return R.ok().message("删除成功");
        else
            return R.error().message("删除失败");
    }




    //河长维修删除
    @ApiOperation("河长维修删除")
    @DeleteMapping("{repairId}")
    public R deleteRepair(@PathVariable String repairId){
        boolean b = repairService.removeById(repairId);
        if(b)
            return R.ok().message("删除成功");
        else
            return R.error().message("删除失败");

    }



    //河长查看维修记录
    @ApiOperation("河长查看维修记录")
    @GetMapping("manager/{managerId}")
    public R getManagerRepair(@PathVariable String managerId){
        QueryWrapper<Repair> repairQueryWrapper = new QueryWrapper<>();
        repairQueryWrapper.eq("manager_id",managerId);
        List<Repair> list = repairService.list(repairQueryWrapper);
        return R.ok().data("repairList",list);
    }

}
