package com.asher.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory  sessionFactory = null;
	
	static{
		//加载配置文件
		Configuration configuration = new Configuration().configure();
		try {
			//得到sessionFactory
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			//初始化sessionFactory失败
			System.out.println("Initial SessionFactory creation failed.");
			e.printStackTrace();
		}
	}
	//返回sessionFactory对象
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
