package com.asher.crm.department.dao;

import java.util.List;

import com.asher.crm.department.domain.CrmDepartment;

public interface DepartmentDao {
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<CrmDepartment> findAll();
	/**
	 * 根据ID查询部门
	 * @param depId
	 * @return
	 */
	public CrmDepartment findById(String depId);
	/**
	 * 添加或修改部门
	 * @param department
	 */
	public void saveOrUpdate(CrmDepartment department);
	/**
	 * 分页总记录数
	 * @return
	 */
	public int getTotalRecord();
	/**
	 * 分页查询
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<CrmDepartment> findAll(int startIndex, int pageSize);
}
