package com.asher.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.asher.util.HibernateUtils;
import com.asherspace.domain.Customer;
import com.asherspace.domain.Order;

public class Test4 {
	@Test
	public void test4(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
	//----------------------------------------------
		System.out.println(session);
	//----------------------------------------------
		//关闭事物、session和sessionFactory
		ts.commit();
		session.close();
		sessionFactory.close();
	}
}
