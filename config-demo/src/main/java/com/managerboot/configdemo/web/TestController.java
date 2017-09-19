package com.managerboot.configdemo.web;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huabo on 2017/9/18.
 */
@RestController
public class TestController {

//    @Value("${test}")
//    private String test;

    @Autowired
    private Environment environment;

    @RequestMapping("test")
    public Object getConfig(){
        return environment.getProperty("test");
    }

}
