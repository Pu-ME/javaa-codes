package com.asher.service;

import com.asher.domain.User;

public interface UserService {
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	int regist(User user);
}
