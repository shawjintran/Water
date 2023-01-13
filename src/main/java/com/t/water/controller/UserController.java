package com.t.water.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {
	@PostMapping("login")
	public void login(){

	}
	@GetMapping("logout")
	public void logout(){

	}
}
