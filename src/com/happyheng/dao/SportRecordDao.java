package com.happyheng.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.omg.CORBA.INTERNAL;

import com.happyheng.entity.SportRecord;

public interface SportRecordDao {
	
	/**
	 * 将userId插入到用户运动表中，获取自增的运动id
	 * @param connection
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public int insertUserId(Connection connection,int userId) throws SQLException;
	

	/**
	 * 将SportRecord保存至数据库中
	 * 
	 * @param connection
	 * @param record
	 * @throws SQLException
	 */
	public void insert(Connection connection, SportRecord record) throws SQLException;

	
	/**
	 * 根据运动的id获取对已经的运动的所有信息
	 * @param connection
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public List<SportRecord> queryRecordList(Connection connection, int id) throws SQLException;
}
