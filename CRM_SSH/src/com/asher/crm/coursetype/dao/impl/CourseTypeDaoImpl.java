package com.asher.crm.coursetype.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.asher.crm.coursetype.dao.CourseTypeDao;
import com.asher.crm.coursetype.domain.CrmCourseType;
import com.asher.crm.page.PageHibernateCallback;

public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {

	public List<CrmCourseType> findAll(String condition, Object[] params) {
		String sql = "from CrmCourseType where 1=1 " +condition;
		return this.getHibernateTemplate().find(sql,params);
	}

	public CrmCourseType findById(String courseTypeId) {
		return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);
	}

	public void saveOrUpdate(CrmCourseType courseType) {
		this.getHibernateTemplate().saveOrUpdate(courseType);
	}

	public int getTotalRecord(String condition, Object[] params) {
		String sql = "select count(c) from  CrmCourseType c where 1=1 " + condition;
		 List<Long> list = this.getHibernateTemplate().find(sql,params);
		 return list.get(0).intValue();
	}

	public List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize) {
		String sql = "from CrmCourseType where 1=1 " +condition;
		return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmCourseType>(sql, params, startIndex, pageSize));
	
	}

	public List<CrmCourseType> findAll() {
		return this.getHibernateTemplate().find("from CrmCourseType");
	}

}
