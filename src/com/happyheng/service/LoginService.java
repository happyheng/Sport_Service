package com.happyheng.service;

import com.happyheng.entity.result.LoginResult;

public interface LoginService {
	public LoginResult login(String userName, String passWord);
}
