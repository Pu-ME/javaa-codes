package com.asher.crm.department.web.action;

import org.apache.commons.lang3.StringUtils;

import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.department.service.DepartmentService;
import com.asher.crm.page.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<CrmDepartment>{
	
	private static final long serialVersionUID = 1L;
	private CrmDepartment department = new CrmDepartment();
	public CrmDepartment getModel() {
		return department;
	}
	
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	private int pageNum = 1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	private int pageSize = 2;
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 查询所有部门
	 * @return
	 */
	public String findAll(){
/*		List<CrmDepartment> alldeDepartments = this.departmentService.findAll();
		ActionContext.getContext().put("alldeDepartments", alldeDepartments);*/
		PageBean<CrmDepartment> pageBean = this.departmentService.findAll(pageNum,pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "findAll";
	}

	public String addOrEditUI(){
		if(StringUtils.isNotBlank(this.getModel().getDepId())){
			CrmDepartment department = this.departmentService.findById(this.getModel().getDepId());
			ActionContext.getContext().getValueStack().push(department);
		}
		return "addOrEditUI";
	}
	
	public String addOrEdit(){
		this.departmentService.addOrEdit(this.getModel());
		return "addOrEdit";
	}
}
