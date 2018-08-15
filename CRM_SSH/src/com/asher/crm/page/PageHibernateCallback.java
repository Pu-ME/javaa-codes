package com.asher.crm.page;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {
	private String hql;
	private Object[] params;
	private int startIndex;
	private int pageSize;
	
	public PageHibernateCallback(String hql, Object[] params, int startIndex, int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}
	public PageHibernateCallback(String hql,  int startIndex, int pageSize) {
		super();
		this.hql = hql;
		this.params = null;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
		//1 通过hql语句，获得Query对象
		Query queryObject = session.createQuery(hql);
		//2 条件设置
		if(params!=null){
			for (int i = 0; i < params.length; i++) {
				queryObject.setParameter(i, params[i]);
			}
		}
		//3 分页
		queryObject.setFirstResult(startIndex);
		queryObject.setMaxResults(pageSize);
		//4 查询所有
		return queryObject.list();
	}

}
