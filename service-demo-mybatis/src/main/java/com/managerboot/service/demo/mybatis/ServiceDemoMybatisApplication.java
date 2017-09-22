package com.managerboot.service.demo.mybatis;

import com.managerboot.service.demo.mybatis.mapper.UpmsUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class ServiceDemoMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDemoMybatisApplication.class, args);
	}

	@Autowired
	private UpmsUserMapper upmsUserMapper;

	@RequestMapping("/test")
	public Object test(){
		return upmsUserMapper.selectById(1);
	}


}
