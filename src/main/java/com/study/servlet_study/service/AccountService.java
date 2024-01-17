package com.study.servlet_study.service;

import com.study.servlet_study.entity.Account;
import com.study.servlet_study.repository.AccountRepository;

public class AccountService {

	private AccountRepository accountRepository;

	// 계정 추가
	public int addAccount(Account account) {
		return accountRepository.saveAccount(account);
	}

	private AccountService() {
		accountRepository = AccountRepository.getInstance();
	}

	// 싱글톤
	private static AccountService instance;

	public static AccountService getInstance() {
		if (instance == null) {
			instance = new AccountService();
		}
		return instance;
	}

	public Account getAccount(String username) {
		return accountRepository.findAccountByUsername(username);
	}
}
