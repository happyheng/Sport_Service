package com.happyheng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.happyheng.dao.SportRecordDao;
import com.happyheng.entity.Location;
import com.happyheng.entity.Sport;
import com.happyheng.entity.SportRecord;

public class SportRecordDaoImpl extends SqlSessionDaoSupport implements SportRecordDao {

	private static final String BASE_STATEMENT = "com.happyheng.mapper.sportRecordMapper.";

	@Override
	public Integer insertSport(Sport sport) throws SQLException {
		return getSqlSession().insert(BASE_STATEMENT + "insertSport" ,sport);
	}

	@Override
	public void insert(SportRecord record) throws SQLException {
		getSqlSession().insert(BASE_STATEMENT + "addSportMessage" ,record);
	}

	@Override
	public List<SportRecord> queryRecordList(int id) throws SQLException {
		
		return null;
	}

	@Override
	public List<Integer> getSportList(String userKey) throws SQLException {
		return getSqlSession().selectList(BASE_STATEMENT + "getSportList" ,userKey);
	}

	@Override
	public List<Location> getSportMessage(String sportId) throws SQLException {
		
		return getSqlSession().selectList(BASE_STATEMENT + "getSportMessage",sportId);
	}

}
