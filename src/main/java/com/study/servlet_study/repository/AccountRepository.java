package com.study.servlet_study.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.entity.Account;

//client가 정보를 서버(서블릿)에 정보를 넘기고
//넘어간 정보는 서비스를 통해 레포지토리에 리스트로 저장된다
//그 리스트가 계정이 추가될때마다 새로 생성되면 안되므로
//단 한 번만 생성되게 하는 싱글톤을 쓴다
//1. instance 변수 생성 2. private 생성자 3. getInstance
public class AccountRepository {
	private List<Account> accountList;

	private AccountRepository() { // 생성자는 무조건 private - 외부에서 생성되는 것을 막는다
		accountList = new ArrayList<>();
	}

	// 싱글톤
	private static AccountRepository instance;

	public static AccountRepository getInstance() {
		if (instance == null) {
			instance = new AccountRepository();
		}
		return instance;
	}

	// 계정 저장
	public int saveAccount(Account account) {
		accountList.add(account);
		return 1;
	}

	// 계정 검색
	public Account findAccountByUsername(String username) {
		Account findAccount = null;

		for (Account account : accountList) {
			if (account.getUsername().equals(username)) {
				findAccount = account;
				break;
			}
		}
		return findAccount;
	}
}
