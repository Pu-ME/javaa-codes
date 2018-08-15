package com.asher.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.asherspace.domain.User;
import com.asher.util.HibernateUtils;

public class TestCRUD {
	//添加数据
	@Test
	public void test1(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		//创建User对象
		User user = new User();
		user.setName("wang");
		user.setPassword("wang");
		//调用session.save()方法添加数据
		session.save(user);
		ts.commit();
		//关闭session和sessionFactory
		session.close();
		sessionFactory.close();
	}
	//根据id查询数据
	@Test
	public void test2(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		//查询id为1的用户并输出
		User user = session.get(User.class, 1);
		System.out.println(user);
		ts.commit();
		//关闭session和sessionFactory
		session.close();
		sessionFactory.close();
	}	
	//修改数据
	@Test
	public void test3(){
		//创建session和sessionFactory
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		//1.根据id查询数据
		User u = session.get(User.class, 1);
		//2.修改属性值
		u.setName("asher");
		//3.调用session.update()方法修改数据
		session.update(u);
		ts.commit();
		//关闭session和sessionFactory
		session.close();
		sessionFactory.close();
	}	
	//删除数据（1）
	@Test
	public void test4(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		User u = session.get(User.class, 1);
		session.delete(u);
		ts.commit();
		//关闭session和sessionFactory
		session.close();
		sessionFactory.close();
	}	
	//删除数据（2）
	@Test
	public void test5(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		User u = new User();
		u.setId(2);
		session.delete(u);
		ts.commit();
		//关闭session和sessionFactory
		session.close();
		sessionFactory.close();
	}
}
