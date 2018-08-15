package com.asher.web.action;

import org.apache.struts2.ServletActionContext;

import com.asher.domain.User;
import com.asher.service.UserService;
import com.asher.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	@Override
	public String execute() {
		return SUCCESS;
	}
	private User user = new User(); 
	private UserService us = new UserServiceImpl();
	
	@Override
	public User getModel() {
		return user;
	}
	public String register(){
		if(us.findUserByUsername(user.getUsername())!=null){
			return "exist";
		}
		int res = us.regist(user);
		if(res>0){
			return SUCCESS;
		}
		return null;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
