package com.asher.crm.department.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.asher.crm.department.dao.DepartmentDao;
import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.page.PageHibernateCallback;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	public List<CrmDepartment> findAll() {
		return this.getHibernateTemplate().find("from CrmDepartment");
	}

	public CrmDepartment findById(String depId) {
		return this.getHibernateTemplate().get(CrmDepartment.class, depId);
	}

	public void saveOrUpdate(CrmDepartment department) {
		this.getHibernateTemplate().saveOrUpdate(department);
	}

	public int getTotalRecord() {
		List<Long> list = this.getHibernateTemplate().find("select count(c) from CrmDepartment c");
		return list.get(0).intValue();
	}

	public List<CrmDepartment> findAll(int startIndex, int pageSize) {
		return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmDepartment>("from CrmDepartment",startIndex,pageSize));
	}
	
}
