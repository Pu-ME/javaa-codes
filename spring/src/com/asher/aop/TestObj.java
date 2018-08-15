package com.asher.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestObj {
	@Test
	public void testAop(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/asher/aop/beans.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.addUser();
		userService.updateUser();
		userService.deleteUser();
	}
}
