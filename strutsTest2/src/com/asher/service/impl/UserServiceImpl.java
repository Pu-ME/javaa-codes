package com.asher.service.impl;

import com.asher.dao.UserDao;
import com.asher.dao.impl.UserDaoImpl;
import com.asher.domain.User;
import com.asher.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	
	@Override
	public User findUserByUsername(String username) {
		return ud.selectUserByUsername(username);
	}

	@Override
	public int regist(User user) {
		return ud.addUser(user);
	}

}
