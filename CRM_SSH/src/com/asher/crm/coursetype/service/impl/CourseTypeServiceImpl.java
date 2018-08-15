package com.asher.crm.coursetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.asher.crm.coursetype.dao.CourseTypeDao;
import com.asher.crm.coursetype.domain.CrmCourseType;
import com.asher.crm.coursetype.service.CourseTypeService;
import com.asher.crm.page.PageBean;

public class CourseTypeServiceImpl implements CourseTypeService {
	private CourseTypeDao courseTypeDao;
	public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
		this.courseTypeDao = courseTypeDao;
	}
	public CrmCourseType findById(String courseTypeId) {
		return courseTypeDao.findById(courseTypeId);
	}
	public void addOrEdit(CrmCourseType courseType) {
		courseTypeDao.saveOrUpdate(courseType);
	}
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType, int pageNum, int pageSize) {
		StringBuilder stringBuilder = new StringBuilder();
		List<Object> paramsList = new ArrayList<Object>();
		
		//课程类别
		if(StringUtils.isNotBlank(courseType.getCourseName())){
			stringBuilder.append(" and courseName like ?");
			paramsList.add("%"+courseType.getCourseName()+"%");
		}
		//课程简介
		if(StringUtils.isNotBlank(courseType.getRemark())){
			stringBuilder.append(" and remark like ?");
			paramsList.add("%"+courseType.getRemark()+"%");
		}
		//总学时：
		if(StringUtils.isNotBlank(courseType.getTotalStart())){
			stringBuilder.append(" and total >= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if(StringUtils.isNotBlank(courseType.getTotalEnd())){
			stringBuilder.append(" and total <= ?");
			paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		//课程费用
		if(StringUtils.isNotBlank(courseType.getCourseCostStart())){
			stringBuilder.append(" and courseCost >= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		if(StringUtils.isNotBlank(courseType.getCourseCostEnd())){
			stringBuilder.append(" and courseCost <= ?");
			paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}
		
		String condition = stringBuilder.toString();
		Object[] params = paramsList.toArray();	
		int totalRecord = this.courseTypeDao.getTotalRecord(condition,params); 
		PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord); 
		List<CrmCourseType> data = this.courseTypeDao.findAll(condition, params,pageBean.getStartIndex(),pageBean.getPageSize());
		pageBean.setData(data);
		return pageBean;
	}
	public List<CrmCourseType> findAll() {
		return this.courseTypeDao.findAll();
	}

}
