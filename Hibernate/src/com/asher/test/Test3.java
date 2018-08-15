package com.asher.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.asher.util.HibernateUtils;
import com.asherspace.domain.Customer;
import com.asherspace.domain.Order;

public class Test3 {
	@Test
	public void test1(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
	//----------------------------------------------
		Query query = session.createQuery("from Customer c inner join fetch  c.orders");
		List<Object> list = query.list();
		for (Object obj : list) {
			System.out.println(obj);
		}
	//----------------------------------------------
		//关闭事物、session和sessionFactory
		ts.commit();
		session.close();
		sessionFactory.close();
	}
}
