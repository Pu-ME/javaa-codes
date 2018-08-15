package com.asher.crm.coursetype.service;

import java.util.List;

import com.asher.crm.coursetype.domain.CrmCourseType;
import com.asher.crm.page.PageBean;

public interface CourseTypeService {
	
	/**
	 * 通过ID查询			
	 * @param courseTypeId
	 * @return
	 */
	public CrmCourseType findById(String courseTypeId);
	/**
	 * 保存或更新
	 * @param courseType
	 */
	public void addOrEdit(CrmCourseType courseType);
	
	/**
	 * 
	 * @param courseType
	 * @param pageNum 当前页
	 * @param pageSize 每页个数
	 * @return
	 */
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType,int pageNum,int pageSize);
	/**
	 * 查询所有类别
	 * @return
	 */
	public List<CrmCourseType> findAll();  
}
