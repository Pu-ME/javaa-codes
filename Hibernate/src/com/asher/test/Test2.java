package com.asher.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.asher.util.HibernateUtils;
import com.asherspace.domain.Customer;
import com.asherspace.domain.Order;
import com.asherspace.domain.User;

public class Test2 {
	/**
	 * 多表添加数据
	 * 打印5条语句
	 * 前三条：插入数据，维护外键
	 * 后两条：维护外键
	 */
	@Test
	public void test1(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
	//----------------------------------------------
		//创建对象
		Customer customer = new Customer();
		customer.setName("jimm");
		Order o1 = new Order();
		o1.setName("肥皂");
		Order o2 = new Order();
		o2.setName("java");
		//维护关系
		customer.getOrders().add(o1);
		customer.getOrders().add(o2);
		o1.setCustomer(customer);
		o2.setCustomer(customer);
		//保存对象
		session.save(customer);
		session.save(o1);
		session.save(o2);
	//----------------------------------------------
		//关闭事物、session和sessionFactory
		ts.commit();
		session.close();
		sessionFactory.close();
	}	
	
	//级联添加
	@Test
	public void test2(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
	//----------------------------------------------
		//创建对象
		Customer customer = new Customer();
		customer.setName("Tom");
		Order o1 = new Order();
		o1.setName("肥皂");
		Order o2 = new Order();
		o2.setName("java");
		//维护关系
		customer.getOrders().add(o1);
		customer.getOrders().add(o2);
		//保存对象
		session.save(customer);
	//----------------------------------------------
		//关闭事物、session和sessionFactory
		ts.commit();
		session.close();
		sessionFactory.close();
	}
	//删除
	@Test
	public void test3(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
	//----------------------------------------------
		//创建对象
		Customer customer = session.get(Customer.class, 4);
		session.delete(customer);
	//----------------------------------------------
		//关闭事物、session和sessionFactory
		ts.commit();
		session.close();
		sessionFactory.close();
	}
	//修改
	@Test
	public void test4(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
	//----------------------------------------------
		//创建对象
		Customer customer = session.get(Customer.class, 10);
		Set<Order> set = customer.getOrders();
		for (Order order : set) {
			if(order.getName().equals("java"))
				session.delete(order);
		}
	//----------------------------------------------
		//关闭事物、session和sessionFactory
		ts.commit();
		session.close();
		sessionFactory.close();
	}
	

	
}
