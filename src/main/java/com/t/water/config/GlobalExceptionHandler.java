package com.t.water.config;


import com.t.water.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public R error(Exception e){
		//
		System.out.println("global exception");
		return R.fail(e);
	}
}
