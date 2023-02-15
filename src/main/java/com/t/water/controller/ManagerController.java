package com.t.water.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.t.water.entity.Manager;
import com.t.water.entity.vo.ManagerQuery;
import com.t.water.entity.vo.ManagerShowVo;
import com.t.water.handler.exceptionhandler.WaterException;
import com.t.water.service.ManagerService;
import com.t.water.utils.R;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@RestController
@RequestMapping("/manager")
@CrossOrigin
@Api(tags = "河长管理")

public class ManagerController {
	@Autowired
	ManagerService managerService;


	/**
	 * 河长登录
	 * @param manager
	 * @return
	 * @throws Exception
	 * 简单判断
	 */
	@PostMapping("login")
	public R login(@RequestBody Manager manager) throws Exception {
		String phone=manager.getPhone();
		String pwd=manager.getPwd();
		log.info("登录"+phone+"&"+pwd);
		if(ObjectUtils.isEmpty(phone)||ObjectUtils.isEmpty(pwd))
		{
			throw new WaterException(20001,"账号或密码未输入");
		}
		QueryWrapper<Manager> wrapper = new QueryWrapper<>();
		wrapper.eq("phone",phone);
		wrapper.eq("pwd",pwd);
		Manager one = managerService.getOne(wrapper);
		if(ObjectUtils.isEmpty(one))
			throw new WaterException(20001,"账号未注册");
		return R.ok().data("manager","one");
	}

	/**
	 * 无
	 * @param phone
	 * @param pwd
	 * @param sms
	 */
	@PostMapping("signup")
	public void signUp(String phone,String pwd,String sms){

	}

	/**
	 * 河长查询分页
	 * @param current
	 * @param limit
	 * @param managerQuery
	 * @return
	 */

	@PostMapping("pageManager/{current}/{limit}")
	public R pageManagerCondition(@PathVariable Long current,
								  @PathVariable Long limit,
								  @RequestBody(required = false) ManagerQuery managerQuery) {
		Page<Manager> managerPage = new Page<>(current, limit);

		//构造条件
		QueryWrapper<Manager> managerQueryWrapper=new QueryWrapper<>();
		if(!StringUtils.isEmpty(managerQuery.getName())){
			managerQueryWrapper.like("name",managerQuery.getName());
		}
		if(!StringUtils.isEmpty(managerQuery.getPost())){
			managerQueryWrapper.eq("post",managerQuery.getPost());
		}
		managerQueryWrapper.orderByDesc("name");
		managerService.page(managerPage,managerQueryWrapper);
		long total = managerPage.getTotal();//获取总记录数
		List<Manager> records = managerPage.getRecords();
		//转变成ManagerShowVo,滤去密码,时间,逻辑删除等
		List<ManagerShowVo> collect = records.stream().map(manager -> {
			ManagerShowVo managerShowVo = new ManagerShowVo();
			BeanUtils.copyProperties(manager, managerShowVo);
			return managerShowVo;
		}).collect(Collectors.toList());
		HashMap<String, Object> map = new HashMap<>();
		map.put("total",total);
		map.put("rows",collect);
		return R.ok().data("map",map);
	}


}
