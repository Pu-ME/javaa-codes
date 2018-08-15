package com.asher.crm.post.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.asher.crm.department.domain.CrmDepartment;
import com.asher.crm.department.service.DepartmentService;
import com.asher.crm.page.PageBean;
import com.asher.crm.post.domain.CrmPost;
import com.asher.crm.post.service.PostService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {
	private CrmPost post = new CrmPost();
	public CrmPost getModel() {
		return post;
	}
	/////////////////////////////////////////////
	/////Service
	private PostService postService;
	public void setPostService(PostService postService) {
		this.postService = postService;
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
	
	/////////////////////////////////////////////
	/////action
	
	/**
	 * ajax通过部门查询所有的职务
	 * @return
	 * @throws IOException 
	 */
	public String findAllWithDepartment() throws IOException{
		
		List<CrmPost> allPost = postService.findAll(post.getDepartment());
		
		//java转换ajax
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"department","staffSet"});
		
		String jsonDate = JSONArray.fromObject(allPost,jsonConfig).toString();
		
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonDate);
		return "none";
	}
	/**
	 * 查询所有职务
	 * @return
	 */
	public String findAll(){
/*		List<CrmPost> allPost = this.postService.findAll();
		ActionContext.getContext().put("allPost", allPost);*/
		PageBean<CrmPost> pageBean = this.postService.findAll(pageNum,pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		return "findAll";
	}
	/**
	 * 添加修改前操作
	 * @return
	 */
	public String addOrEditUI(){
		if(this.getModel().getPostId() != null){
			CrmPost findPost = this.postService.findById(this.getModel().getPostId());
			ActionContext.getContext().getValueStack().push(findPost);
		}
		List<CrmDepartment> allDepartment = this.departmentService.findAll();
		ActionContext.getContext().put("allDepartment", allDepartment);
		return "addOrEditUI";
	}
	/**
	 * 添加修改操作
	 * @return
	 */
	public String addOrEdit(){
		this.postService.addOrEdit(this.getModel());
		return "addOrEdit";
	}
}
