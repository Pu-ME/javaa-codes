package com.asher.domain;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf = null;
	 private HibernateUtils() {}  
	static{
		//加载配置文件
		Configuration configure = new Configuration().configure();
		//得到sessionFactory 
		sf = configure.buildSessionFactory();
		//虚拟机关闭时自动释放sf
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				sf.close();
			}
		}));
	}
	//开启新的session
	public static Session openSession(){
		return sf.openSession();
	}
	//得到当前线程的session
	public static Session getCurrentSession(){
		return sf.getCurrentSession();
	}
}
