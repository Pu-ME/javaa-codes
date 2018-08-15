package com.asher.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.asher.domain.User;
public class TEST {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		User u = new User();
		u.setName("jerry");
		u.setPassword("1234");
		session.save(u);
		session.close();
		sessionFactory.close();
	}
}
