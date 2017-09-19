package com.managerboot.config.client.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientDemoApplication.class, args);
	}

	@Value("${test}")
	private String test;

	@Autowired
	private Environment environment;

	@RequestMapping("/getProperty")
	public String getProperty(){
		return test;
	}

}
