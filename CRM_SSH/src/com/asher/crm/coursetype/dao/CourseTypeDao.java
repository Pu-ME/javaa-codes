package com.asher.crm.coursetype.dao;

import java.util.List;

import com.asher.crm.coursetype.domain.CrmCourseType;

public interface CourseTypeDao {
	/**
	 * 带条件的查询所有课程
	 * @param params 
	 * @param condition 
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition, Object[] params);
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
	public void saveOrUpdate(CrmCourseType courseType);
	
	/**
	 * 分页查询总计录数
	 * @param condition
	 * @param params
	 * @return
	 */
	public int getTotalRecord(String condition, Object[] params);
	/**
	 * 分页查询结果
	 * @param condition
	 * @param params
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize);
	/**
	 * 查询所有类别
	 * @return
	 */
	public List<CrmCourseType> findAll();
}
