package com.happyheng.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.happyheng.dao.UserDao;
import com.happyheng.dao.impl.UserDaoImplement;
import com.happyheng.entity.result.LoginResult;
import com.happyheng.utils.ConnectionFactory;


public class LoginService {
	private UserDao mUserDao = new UserDaoImplement();
	
	private static final int RESULT_NULL_USERNAME = 1,RESULT_WRONG_PASSWORD = 2;

	public LoginResult login(String userName, String passWord) {
		
		Connection connection = null;
		LoginResult result = new LoginResult();
		
		connection = ConnectionFactory.getInstance().makeConnection();
		
		try {
			//1、先判断是否有相应的用户名
			int id = mUserDao.queryUserName(connection, userName);
			if (id == 0) {
				result.setCode(RESULT_NULL_USERNAME);
				return result;
			}
			
			//2、在判断密码是否正确
			int userId = mUserDao.queryPassWord(connection, id, passWord);
			if (userId == 0) {
				result.setCode(RESULT_WRONG_PASSWORD);
				return result;
			}
			
			//3、设置相应的token
			long currentTime  = System.currentTimeMillis();
			String token = userId+"_"+currentTime;
			
			mUserDao.updateToken(connection, userId, token);
			result.setCode(0);
			result.setToken(token);
			
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			result.setCode(100);
			return result;
		}	
	}
	
}
