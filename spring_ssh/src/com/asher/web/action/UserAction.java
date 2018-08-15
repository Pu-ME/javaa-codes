package com.asher.web.action;

import com.asher.UserService.UserService;
import com.asher.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String register(){
		userService.register(user);
		return "success";
	}
}
