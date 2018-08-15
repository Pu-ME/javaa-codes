package com.asher.crm.staff.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.asher.crm.staff.dao.StaffDao;
import com.asher.crm.staff.domain.CrmStaff;
import com.asher.crm.staff.service.StaffService;
import com.asher.crm.utils.MyStringUtils;

public class StaffServiceImpl implements StaffService {

	private StaffDao staffDao;
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	public CrmStaff login(CrmStaff staff) {
		String loginPwd = MyStringUtils.getMD5Value(staff.getLoginPwd());
		return staffDao.find(staff.getLoginName(), loginPwd); 
	}

	public List<CrmStaff> findAllStaff(CrmStaff staff) {
		StringBuilder builder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		//部门
		if(staff.getPost() != null && staff.getPost().getDepartment() != null){
			if(StringUtils.isNotBlank(staff.getPost().getDepartment().getDepId())){
				builder.append(" and post.department.depId = ? ");
				paramsList.add(staff.getPost().getDepartment().getDepId());
			}
		}
		//职务
		if(staff.getPost() != null){
			if(StringUtils.isNotBlank(staff.getPost().getPostId())){
				builder.append(" and post.postId = ? ");
				paramsList.add(staff.getPost().getPostId());
			}
		}
		//姓名
		if(StringUtils.isNotBlank(staff.getStaffName())){
			builder.append(" and staffName like  ? ");
			paramsList.add("%"+staff.getStaffName()+"%");
		}
		
		String condition = builder.toString();
		Object []params = paramsList.toArray();
		return staffDao.findAll(condition,params);
	}

	public CrmStaff findById(String staffId) {
		return staffDao.findById(staffId);
	}

	public void updateStaff(CrmStaff staff) {
		CrmStaff findStaff = staffDao.findById(staff.getStaffId());
		if( !findStaff.getLoginPwd().equals(staff.getLoginPwd())){
			findStaff.setLoginPwd(MyStringUtils.getMD5Value(staff.getLoginPwd()));
		}
		findStaff.setLoginName(staff.getLoginName());
		findStaff.setStaffName(staff.getStaffName());
		findStaff.setGender(staff.getGender());
		findStaff.setOnDutyDate(staff.getOnDutyDate());
		findStaff.setPost(staff.getPost());
		
	}

	public void addStaff(CrmStaff staff) {
		String loginPwd = staff.getLoginPwd();
		loginPwd = MyStringUtils.getMD5Value(loginPwd);
		staff.setLoginPwd(loginPwd);
		this.staffDao.save(staff);
	}
	
}
