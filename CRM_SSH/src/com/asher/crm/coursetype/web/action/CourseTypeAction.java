package com.asher.crm.coursetype.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.asher.crm.coursetype.dao.CourseTypeDao;
import com.asher.crm.coursetype.domain.CrmCourseType;
import com.asher.crm.coursetype.service.CourseTypeService;
import com.asher.crm.page.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {
	private CrmCourseType courseType = new CrmCourseType();
	public CrmCourseType getModel() {
		return courseType;
	}
	//////////////////////////////////////////////////
	//Service
	
	private CourseTypeService courseTypeService;
	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	
	private int pageNum = 1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	private int pageSize = 2;
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	} 
	////////////////////////////////////////////////
	//
	
	public String findAll(){
		PageBean<CrmCourseType> pageBean = this.courseTypeService.findAll(courseType, pageNum, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "findAll";
	}

	public String addOrEditUI(){
		if(StringUtils.isNotBlank(this.courseType.getCourseTypeId())){
			CrmCourseType findCouserType = courseTypeService.findById(this.courseType.getCourseTypeId());
			ActionContext.getContext().getValueStack().push(findCouserType);
		}
		return "addOrEditUI";
	}
	
	public String addOrEdit(){
		this.courseTypeService.addOrEdit(courseType);
		return "addOrEdit";
	}
}
