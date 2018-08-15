package com.asher.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asher.service.AccountService;

public class TestAop {

	@Test
	public void test1(){
		String path = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.transfer("jack", "rose", 1000);
	}
}
