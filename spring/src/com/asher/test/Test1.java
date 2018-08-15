package com.asher.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	
	@Test
	public void test(){
		String path = "com/asher/test/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.add();
	}
}
