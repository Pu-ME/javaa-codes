package com.asher.test;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.asher.util.HibernateUtils;

public class Test1 {
	@Test
	public void test(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction ts = null;
		
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			ts = session.beginTransaction();
			//-----------------------------------------------------
			
			
			
			
			//-----------------------------------------------------
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
		
				
	}
	
}
