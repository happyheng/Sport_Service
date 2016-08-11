package com.happyheng.factory;

import com.happyheng.dao.UserDao;
import com.happyheng.utils.MyBatisUtil;

public class UserDaoFactory {
	
	public UserDao getUserDao() {
		return MyBatisUtil.getSqlSession(true).getMapper(UserDao.class);
	}
}
