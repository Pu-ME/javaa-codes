package com.asher.crm.post.dao;

import java.util.List;

import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.post.domain.CrmPost;

public interface PostDao {
	/**
	 * 查询部门的所有职务
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment department);
	/**
	 * 查询所有职务
	 * @return
	 */
	public List<CrmPost> findAll();
	/**
	 * 通过Id查询职务
	 * @param postId
	 * @return
	 */
	public CrmPost findById(String postId);
	/**
	 * 添加或修改
	 * @param post
	 */
	public void saveOrUpdate(CrmPost post);
	/**
	 * 分页查询总记录数
	 * @return
	 */
	public int getTotalRecord();
	/**
	 * 分页查询
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<CrmPost> findAll(int startIndex, int pageSize);
}
