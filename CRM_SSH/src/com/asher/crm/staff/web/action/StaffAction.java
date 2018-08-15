package com.asher.crm.staff.web.action;

import java.util.List;

import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.department.service.DepartmentService;
import com.asher.crm.staff.domain.CrmStaff;
import com.asher.crm.staff.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff>{
	
	private static final long serialVersionUID = 1L;
	private CrmStaff staff = new CrmStaff();
	public CrmStaff getModel() {
		return staff;
	}
	/**
	 * 员工Service
	 */
	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	/**
	 * 部门Service
	 */
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	////////////////////////////////////////////////////////
	/**
	 * 登录
	 * @return
	 */
	public String login(){
		//查询员工
		CrmStaff findStaff = staffService.login(staff);
		//是否成功
		if(findStaff != null){
			ActionContext.getContext().getSession().put("loginStaff", findStaff);
			return "success";
		}
		//不成功，添加提示信息
		this.addFieldError("", "用户名或密码错误！");
		return "login";
	}
	/**
	 * 显示首页
	 * @return
	 */
	public String home(){
		return "home";
	}
	
	public String logout(){
		ActionContext.getContext().getSession().remove("loginStaff");
		return "logout";
	}
	/**
	 * 查询所有员工
	 * @return
	 */
	public String findAll(){
		/*//所有员工
		List<CrmStaff> allStaff = staffService.findAllStaff();
		ActionContext.getContext().put("allStaff", allStaff);*/
		//所有部门
		List<CrmDepartment> allDepartments = this.departmentService.findAll();
		ActionContext.getContext().getValueStack().set("allDepartments", allDepartments);
		
		List<CrmStaff> allStaff = this.staffService.findAllStaff(this.getModel());
		ActionContext.getContext().put("allStaff", allStaff);
		return "findAll";
	}
	/**
	 * 编辑前操作
	 * @return
	 */
	public String editUI(){
		//通过ID查询员工
		CrmStaff findStaff = staffService.findById(staff.getStaffId());
		ActionContext.getContext().getValueStack().push(findStaff);
		//查询所有部门
		List<CrmDepartment> allDepartments = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("allDepartments", allDepartments);
		return "editUI";
	}
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		staffService.updateStaff(staff);
		return "edit";
	}
	/**
	 * 添加前操作
	 * @return
	 */
	public String addUI(){
		List<CrmDepartment> allDepartments = this.departmentService.findAll();
		ActionContext.getContext().getValueStack().set("allDepartments", allDepartments);
		return "addUI";
	}
	
	public String add(){
		this.staffService.addStaff(this.getModel());
		return "add";
	}
	
}
