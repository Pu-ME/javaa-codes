package com.asher.test02;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	
	@Test
	public void test() throws Exception{
		String path = "com/asher/test02/beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		UserDao userDao =  applicationContext.getBean("userDao",UserDao.class);
		userDao.save();
		applicationContext.getClass().getMethod("close").invoke(applicationContext);
	}
}
