package com.happyheng.dao.impl;

import java.sql.SQLException;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.happyheng.dao.NewsCountDao;

public class NewsCountDaoImpl extends SqlSessionDaoSupport implements NewsCountDao {

	private static final String BASE_STATEMENT = "com.happyheng.mapper.userMapper.";
	
	@Override
	public Integer getNewsReadCount(int id) throws SQLException {
		return getSqlSession().selectOne(BASE_STATEMENT+"selectNewsCount",id);
	}

}
