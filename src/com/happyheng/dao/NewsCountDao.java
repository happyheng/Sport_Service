package com.happyheng.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Select;

public interface NewsCountDao {
	
	/**
	 * 获取指定的readCount
	 * @param connection
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@Select("select readcount from tal_news where id = #{id}")
	public Integer getNewsReadCount(int id) throws SQLException;
}
