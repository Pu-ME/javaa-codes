package com.asher.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asher.UserService.UserService;
import com.asher.domain.User;

public class TestSSH {
	@Test
	public void testSSH(){
		String path = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		UserService userService = (UserService) applicationContext.getBean("userService");
		User user = new User();
		user.setUsername("asher");
		user.setPassword("12356");
		user.setAge(29);
		userService.register(user);
	}
}
