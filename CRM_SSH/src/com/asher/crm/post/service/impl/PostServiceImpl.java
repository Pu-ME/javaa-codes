package com.asher.crm.post.service.impl;

import java.util.List;

import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.page.PageBean;
import com.asher.crm.post.dao.PostDao;
import com.asher.crm.post.domain.CrmPost;
import com.asher.crm.post.service.PostService;

public class PostServiceImpl implements PostService {
	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	public List<CrmPost> findAll(CrmDepartment department) {
		return postDao.findAll(department);
	}

	public List<CrmPost> findAll() {
		return this.postDao.findAll();
	}

	public CrmPost findById(String postId) {
		return this.postDao.findById(postId);
	}

	public void addOrEdit(CrmPost post) {
		this.postDao.saveOrUpdate(post);
	}

	public PageBean<CrmPost> findAll(int pageNum, int pageSize) {
		int totalRecord = this.postDao.getTotalRecord();
		PageBean<CrmPost> pageBean = new PageBean<CrmPost>(pageNum, pageSize, totalRecord);
		List<CrmPost> data = this.postDao.findAll(pageBean.getStartIndex(),pageBean.getPageSize());
		pageBean.setData(data);
		return pageBean;
	}

}
