package com.asher.test02;

public class UserDaoImpl implements UserDao {

	public void save(){
		System.out.println("UserDao!");
	}
	
	public void myInit(){
		System.out.println("myinit");
	}
	public void myDestory(){
		System.out.println("myDestory");
	}
}
