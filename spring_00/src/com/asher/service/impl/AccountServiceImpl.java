package com.asher.service.impl;

import javax.transaction.Transactional;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.asher.dao.AccountDao;
import com.asher.service.AccountService;

@Transactional
public class AccountServiceImpl implements AccountService{
	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	@Override
	public void transfer(final String inner, final String outer,final Integer money) {
		accountDao.out(outer, money);
		accountDao.in(inner, money);				
	}

}
