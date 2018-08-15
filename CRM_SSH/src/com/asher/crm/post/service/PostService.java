package com.asher.crm.post.service;

import java.util.List;

import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.page.PageBean;
import com.asher.crm.post.domain.CrmPost;

public interface PostService {
	/**
	 * 查询部门所有职务
	 * @param department
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment department);
	/**
	 * 查询所有职务
	 * @return
	 */
	public List<CrmPost> findAll();
	/**
	 * 通过ID查询职务
	 * @param postId
	 * @return
	 */
	public CrmPost findById(String postId);
	/**
	 * 添加修改操作
	 * @param model
	 */
	public void addOrEdit(CrmPost post);
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageBean<CrmPost> findAll(int pageNum, int pageSize);
}
