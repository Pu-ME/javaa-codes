package com.asher.UserService.Impl;

import com.asher.UserService.UserService;
import com.asher.dao.UserDao;
import com.asher.domain.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void register(User user) {
		userDao.add(user);
	}

}
