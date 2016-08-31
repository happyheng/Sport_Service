package com.happyheng.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.happyheng.dao.UserDao;
import com.happyheng.entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	private static final String BASE_STATEMENT = "com.happyheng.mapper.userMapper.";

	@Override
	public void save(User user) {
		getSqlSession().update(BASE_STATEMENT+"saveUser",user);
	}

	@Override
	public Integer queryUserName(String userName) {
		return getSqlSession().selectOne(BASE_STATEMENT+"selectUserByName",userName);
	}

	@Override
	public Integer queryPassWord(int id, String password) {
		
		Map<String, String> map = new HashMap<>();
		map.put("id", String.valueOf(id));
		map.put("password", password);
		return getSqlSession().selectOne(BASE_STATEMENT+"selectUserByPassword", map);
	}

	@Override
	public int updateToken(int userId, String token) {
		Map<String, String> map = new HashMap<>();
		map.put("id", String.valueOf(userId));
		map.put("token", token);
		return getSqlSession().update(BASE_STATEMENT+"updateUserToken",map);
	}

	@Override
	public Integer getUserId(String token) {
		System.out.println("token为"+token);
		return getSqlSession().selectOne(BASE_STATEMENT+"selectUserByToken",token);
	}

}
