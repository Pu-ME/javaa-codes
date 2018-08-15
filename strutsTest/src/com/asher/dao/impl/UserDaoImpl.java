package com.asher.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.asher.dao.UserDao;
import com.asher.domain.User;
import com.asher.util.C3P0Util;


public class UserDaoImpl implements UserDao{
	
	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	
	@Override
	public int addUser(User user)  {
		try {
			return qr.update("insert into user(username,password,email,birthday) values(?,?,?,?)",user.getUsername(),user.getPassword(),user.getEmail(),user.getBirthday());
		} catch (SQLException e) {
            throw new RuntimeException();
            }
	}

	@Override
	public User selectUserByUsername(String username) {
		
		try {
			return qr.query("select * from user where username=?", new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
