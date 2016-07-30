package com.happyheng.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface NewsCountDao {
	
	/**
	 * 获取指定的readCount
	 * @param connection
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	String getNewsReadCount(Connection connection, String id) throws SQLException;
}
