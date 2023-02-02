package com.t.water;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.t.water.mapper")
@Slf4j
@SpringBootApplication
public class WaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaterApplication.class, args);
	}

}
