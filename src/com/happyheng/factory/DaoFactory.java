package com.happyheng.factory;

import com.happyheng.dao.NewsCountDao;
import com.happyheng.dao.NewsDao;
import com.happyheng.dao.SportRecordDao;
import com.happyheng.dao.UserDao;
import com.happyheng.utils.MyBatisUtil;

public class DaoFactory {
	
	public UserDao getUserDao() {
		return MyBatisUtil.getSqlSession(true).getMapper(UserDao.class);
	}
	
	public SportRecordDao getSportRecordDao() {
		return MyBatisUtil.getSqlSession(true).getMapper(SportRecordDao.class);
	}
	
	public NewsDao getNewsDao() {
		return MyBatisUtil.getSqlSession(true).getMapper(NewsDao.class);
	}
	
	public NewsCountDao getNewsCountDao() {
		return MyBatisUtil.getSqlSession(true).getMapper(NewsCountDao.class);
	}
}
