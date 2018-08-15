package com.asher.crm.staff.dao;

import java.util.List;

import com.asher.crm.staff.domain.CrmStaff;

public interface StaffDao {
	/**
	 * 查找员工
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public CrmStaff find(String loginName,String loginPwd);
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<CrmStaff> findAll(String condition,Object []params);
	/**
	 * 根据ID查询用户
	 * @param staffId
	 * @return
	 */
	public CrmStaff findById(String staffId);
	/**
	 * 添加员工
	 * @param staff
	 */
	public void save(CrmStaff staff);
}
