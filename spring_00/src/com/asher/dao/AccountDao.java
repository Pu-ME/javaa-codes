package com.asher.dao;

public interface AccountDao {
	void in(String inner,Integer money);
	void out(String outer,Integer money);	
}
