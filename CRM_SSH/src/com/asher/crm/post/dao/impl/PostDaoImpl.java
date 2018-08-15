package com.asher.crm.post.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.page.PageHibernateCallback;
import com.asher.crm.post.dao.PostDao;
import com.asher.crm.post.domain.CrmPost;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

	public List<CrmPost> findAll(CrmDepartment department) {
		return this.getHibernateTemplate().find("from CrmPost where department = ?",department);
	}

	public List<CrmPost> findAll() {
		return this.getHibernateTemplate().find("from CrmPost");
	}

	public CrmPost findById(String postId) {
		return this.getHibernateTemplate().get(CrmPost.class, postId);
	}

	public void saveOrUpdate(CrmPost post) {
		this.getHibernateTemplate().saveOrUpdate(post);
	}

	public int getTotalRecord() {
		List<Long> list = this.getHibernateTemplate().find("select count(c) from CrmPost c");
		return list.get(0).intValue();
	}

	public List<CrmPost> findAll(int startIndex, int pageSize) {
		return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmPost>("from CrmPost",  startIndex, pageSize));
	}

}
