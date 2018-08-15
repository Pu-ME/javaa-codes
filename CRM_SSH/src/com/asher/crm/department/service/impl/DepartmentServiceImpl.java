package com.asher.crm.department.service.impl;

import java.util.List;

import com.asher.crm.department.dao.DepartmentDao;
import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.department.service.DepartmentService;
import com.asher.crm.page.PageBean;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public List<CrmDepartment> findAll() {
		return departmentDao.findAll();
	}

	public CrmDepartment findById(String depId) {
		return this.departmentDao.findById(depId);
	}

	public void addOrEdit(CrmDepartment department) {
		this.departmentDao.saveOrUpdate(department);
	}

	public PageBean<CrmDepartment> findAll(int pageNum, int pageSize) {
		int totalRecord = this.departmentDao.getTotalRecord();
		PageBean<CrmDepartment> pageBean = new PageBean<CrmDepartment>(pageNum, pageSize, totalRecord);
		List<CrmDepartment> data = this.departmentDao.findAll(pageBean.getStartIndex(),pageBean.getPageSize());
		pageBean.setData(data);
		return pageBean;
	}

}
