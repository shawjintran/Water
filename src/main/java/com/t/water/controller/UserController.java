package com.t.water.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.t.water.config.WaterException;
import com.t.water.entity.RiverManager;
import com.t.water.service.RiverManagerService;
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
	RiverManagerService riverManagerService;
	@PostMapping("login")
	public R login(String phone, String pwd) throws Exception {
		if(ObjectUtils.isEmpty(phone)||ObjectUtils.isEmpty(pwd))
		{
			return R.fail().setMes("");
		}
		QueryWrapper<RiverManager> wrapper = new QueryWrapper<>();
		wrapper.eq("river_phonenumber",phone);
		wrapper.eq("river_pwd",pwd);
		RiverManager one = riverManagerService.getOne(wrapper);
		if(ObjectUtils.isEmpty(one))
			return R.fail().setMes("");
		return R.ok().setData(one);
	}
	@GetMapping("logout")
	public void logout(){

	}
	@PostMapping("signup")
	public void signUp(String phone,String pwd,String sms){

	}
}
