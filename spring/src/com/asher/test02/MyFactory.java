package com.asher.test02;

public class MyFactory {
	
/*	public static UserDao createUserDao(){
		return new UserDaoImpl();
	}*/
	
	public UserDao createUserDao(){
		return new UserDaoImpl();
	}
}
