package com.asher.dao;

import com.asher.domain.User;

public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User selectUserByUsername(String username);

}
