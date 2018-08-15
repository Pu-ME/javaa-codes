package com.asher.domain;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

public class Junit {
	@Test
	public void test(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		/*Query query = session.createQuery("from User");
		List<User> list = query.list();
		System.out.println(list);*/
		
		//@Deprecated
		/*Criteria criteria = session.createCriteria(User.class);
		List<User> list = criteria.list();
		System.out.println(list);*/
		
		
		
		session.close();
		sessionFactory.close();
	}
	
	//OID查询
	@Test
	public void test1(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//根据id查出一条记录
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		session.close();
		sessionFactory.close();
	}
	
	//HQL查询
	@Test
	public void test2(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//获得query对象
		Query query = session.createQuery("from User");
		//使用query的list()方法得到结果集合
		List<User> list = query.list();
		//遍历集合输出每一个user
		for (User user : list) {
			System.out.println(user);
		}
		
		session.close();
		sessionFactory.close();
	}
	
	//HQL准确查询查询.查询名字为jerry的信息
	@Test
	public void test3(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//获得query对象
		Query query = session.createQuery("from User where name = ?");
		//填写上一句中占位符的内容
		query.setParameter(0, "jerry");
		//使用query的list()方法得到结果集合
		List<User> list = query.list();
		//遍历集合输出每一个user
		for (User user : list) {
			System.out.println(user);
		}
		
		session.close();
		sessionFactory.close();
	}


	//HQL模糊查询查询.查询名字中含字母o的信息
	@Test
	public void test4(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//获得query对象
		Query query = session.createQuery("from User where name like ?");
		//填写上一句中占位符的内容
		query.setParameter(0, "%o%");
		//使用query的list()方法得到结果集合
		List<User> list = query.list();
		//遍历集合输出每一个user
		for (User user : list) {
			System.out.println(user);
		}
		
		session.close();
		sessionFactory.close();
	}
	
	//HQL排序查询,id正序查询
	@Test
	public void test5(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//获得query对象
		Query query = session.createQuery("from User order by id asc");
		//使用query的list()方法得到结果集合
		List<User> list = query.list();
		//遍历集合输出每一个user
		for (User user : list) {
			System.out.println(user);
		}
		
		session.close();
		sessionFactory.close();
	}
	
	//HQL排序查询,id倒序查询
	@Test
	public void test6(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//获得query对象
		Query query = session.createQuery("from User order by id desc");
		//使用query的list()方法得到结果集合
		List<User> list = query.list();
		//遍历集合输出每一个user
		for (User user : list) {
			System.out.println(user);
		}
		
		session.close();
		sessionFactory.close();
	}
	
	//HQL分页查询,每页3条数据
	@Test
	public void test7(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//获得query对象
		Query query = session.createQuery("from User");
		// 使用Query的方法实现分页,计算公式：（当前页数-1）*每页的记录数
		//setFirstResult()设置第一个要查询的位置，setMaxResults()设置每页显示的最大记录数。
		query.setFirstResult(0);
		query.setMaxResults(3);
		//使用query的list()方法得到结果集合
		List<User> list = query.list();
		//遍历集合输出每一个user
		for (User user : list) {
			System.out.println(user);
		}
		
		session.close();
		sessionFactory.close();
	}
	
	//HQL聚集函数查询,count
	@Test
	public void test8(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//获得query对象
		Query query = session.createQuery("select count(*) from User");
		//获取结果（结果为long型）
		Object object = query.uniqueResult();
		System.out.println(object);
       /* 结果转换为int
        * Long long1 = (Long) object;
        int count = long1.intValue();
        System.out.println(count);*/
		
		session.close();
		sessionFactory.close();
	}
	
	
	//HQL投影查询，查询name字段
	@Test
	public void test9(){
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//获得query对象
		Query query = session.createQuery("select name from User");
		//获得结果集合
		List<Object> list = query.list();
		//遍历集合输出每一个user
		for (Object obj : list) {
			System.out.println(obj);
		}
		
		session.close();
		sessionFactory.close();
	}
}
