package com.asher.crm.staff.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.asher.crm.staff.dao.StaffDao;
import com.asher.crm.staff.domain.CrmStaff;

public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao{

	public CrmStaff find(String loginName, String loginPwd) {
		List<CrmStaff> allStaff = this.getHibernateTemplate().find("from CrmStaff where loginName=? and loginPwd = ?", loginName,loginPwd);
		if(allStaff.size()==1){
			return allStaff.get(0);
		}
		return null;
	}

	public CrmStaff findById(String staffId) {
		return this.getHibernateTemplate().get(CrmStaff.class, staffId);
	}

	public void save(CrmStaff staff) {
		this.getHibernateTemplate().save(staff);
	}

	public List<CrmStaff> findAll(String condition, Object[] params) {
		String sql = " from CrmStaff where 1=1 " + condition;
		return this.getHibernateTemplate().find(sql, params);
	}
	

}
