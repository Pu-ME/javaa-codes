package com.asher.crm.staff.service;

import java.util.List;

import com.asher.crm.staff.domain.CrmStaff;

public interface StaffService {
	/**
	 * 登录服务
	 * @param staff
	 * @return
	 */
	public CrmStaff login(CrmStaff staff);
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<CrmStaff> findAllStaff(CrmStaff staff);
	/**
	 * 根据ID查询
	 * @param satffId
	 * @return
	 */
	public CrmStaff findById(String satffId);
	/**
	 * 更新员工
	 * @param staff
	 */
	public void updateStaff(CrmStaff staff);
	/**
	 * 添加员工
	 * @param model
	 */
	public void addStaff(CrmStaff staff);
} 
