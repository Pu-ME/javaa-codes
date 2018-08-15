package com.asher.crm.department.service;

import java.util.List;

import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.page.PageBean;

public interface DepartmentService {
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
	 * @param model
	 */
	public void addOrEdit(CrmDepartment department);
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageBean<CrmDepartment> findAll(int pageNum, int pageSize);
}
