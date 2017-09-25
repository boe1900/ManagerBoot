package com.managerboot.service.demo.mybatis;

import com.managerboot.service.demo.mybatis.entity.Order;
import com.managerboot.service.demo.mybatis.mapper.OrderMapper;
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

	@Resource
	private UpmsUserMapper upmsUserMapper;


	@Resource
	private OrderMapper orderMapper;

	@RequestMapping("/test")
	public Object test(){
		return upmsUserMapper.selectById(1);
	}



	@RequestMapping("/add")
	public Object add() {
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setUserId((long) i);
			order.setOrderId((long) i);
			orderMapper.insert(order);
		}
		for (int i = 10; i < 20; i++) {
			Order order = new Order();
			order.setUserId((long) i + 1);
			order.setOrderId((long) i);
			orderMapper.insert(order);
		}
		return "success";
	}
	@RequestMapping("query")
	private Object queryAll() {
		Order order = new Order();
		order.setUserId(11L);
		return orderMapper.selectOne(order);
	}

}
