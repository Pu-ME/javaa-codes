package com.asher.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.asher.dao.UserDao;
import com.asher.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}

}
