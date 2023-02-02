package com.t.water.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.t.water.entity.Manager;
import com.t.water.handler.exceptionhandler.WaterException;
import com.t.water.service.ManagerService;
import com.t.water.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
@Api(tags = "")
public class UserController {
	@Autowired
	ManagerService managerService;
	@PostMapping("login")
	public R login(@RequestBody Manager manager) throws Exception {
		String phone=manager.getPhone();
		String pwd=manager.getPwd();
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
		return R.ok().data("manager",one);
	}
	@GetMapping("logout")
	public void logout(){

	}
	@PostMapping("signup")
	public void signUp(String phone,String pwd,String sms){

	}
}
