package com.asher.crm.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.asher.crm.base.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	//T  编译时，注释变量。在运行时，才可以获得具体的类型
	private Class<?> beanClass;
	public BaseDaoImpl() {
		//获得运行时的类型 , BaseDaoImpl<CrmStaff>被参数化的类型
		ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得实际参数的 ,获得所有。此时只有一个
		beanClass = (Class<?>) paramType.getActualTypeArguments()[0];
	}
	public void save(Object t) {
		this.getHibernateTemplate().save(t);
	}
	public void update(Object t) {
		this.getHibernateTemplate().update(t);
	}
	public void delete(Object t) {
		this.getHibernateTemplate().delete(t);
	}
	public void saveOrUpdate(Object t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(beanClass, id);
	}
	public List<T> findAll() {
		// getName() 获得类的全限定名称， com.asher.crm.staff.domain.CrmStaff
		return this.getHibernateTemplate().find("from " + beanClass.getName());
	}


	
}
