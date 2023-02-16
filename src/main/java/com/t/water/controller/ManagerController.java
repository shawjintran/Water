package com.t.water.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.t.water.entity.Manager;
import com.t.water.entity.dto.ManagerDto;
import com.t.water.entity.vo.ManagerQuery;
import com.t.water.entity.vo.ManagerShowVo;
import com.t.water.handler.exceptionhandler.WaterException;
import com.t.water.service.ManagerService;
import com.t.water.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
	@ApiOperation("客户端登录")
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
	 *
	 * @param phone
	 * @param pwd
	 * @param smsCode
	 * @return
	 */

	@ApiOperation("注册")
	@PostMapping("signup")
	public R signUp(String phone, String pwd, String smsCode){
		//判断验证码
		if(!StringUtils.isEmpty(smsCode)){
			log.info("验证码不为空,验证码判断");
			//判断验证码
		}else{
			return R.ok().message("验证码错误");
		}
		if(!StringUtils.isEmpty(phone)&&!StringUtils.isEmpty(pwd)){
			log.info("电话号码和密码都不为空");
			Manager manager = new Manager();
			manager.setPhone(phone);
			manager.setPwd(pwd);
			boolean save = managerService.save(manager);
			if(save)
				return R.ok().message("注册成功");
			else
				return R.error().message("注册失败");
		}


		return R.error().message("电话或密码未填写");
	}


	/**
	 * 修改河长个人信息
	 * @param managerDto
	 * @return
	 */
	@ApiOperation("河长修改个人信息")
	@PostMapping("updata")
	public R updataManager(@RequestBody ManagerDto managerDto){
		//获取原信息

		UpdateWrapper<Manager> managerUpdateWrapper = new UpdateWrapper<>();
			managerUpdateWrapper.eq("id",managerDto.getId());
		if(!StringUtils.isEmpty(managerDto.getName()))//名字更新
			managerUpdateWrapper.set("name",managerDto.getName());
		if(!StringUtils.isEmpty(managerDto.getPost()))//职位更新
			managerUpdateWrapper.set("post",managerDto.getPost());
		if(!StringUtils.isEmpty(managerDto.getProfileUrl()))//头像更新
			managerUpdateWrapper.set("profile_url",managerDto.getProfileUrl());
		if(!StringUtils.isEmpty(managerDto.getAddress()))//地址更新
			managerUpdateWrapper.set("address",managerDto.getAddress());
		boolean update = managerService.update(managerUpdateWrapper);
		if(update)
			return R.ok().message("修改成功");
		else
			return R.error().message("修改失败");
	}





	@ApiOperation("验证码生成")
	@GetMapping("smsCode/{phone}")
	public R smsCodeCreate(@PathVariable String phone){
		String smsCode="http://lkw-img.oss-cn-chengdu.aliyuncs.com/img/image-20230216114859659.png";
		return R.ok().data("smsCode",smsCode);
	}




//
//
//	@ApiOperation("河长修改密码")
//	@PostMapping("updataPwd/{oldPwd")
//
//



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
