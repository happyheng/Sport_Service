package com.happyheng.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.happyheng.entity.News;

public interface NewsDao {
	
	/**
	 * 通过开始位置和count来得到News实体
	 * @param begin
	 * @param count
	 * @return
	 */
	List<News> getNewsByIndex(Connection connection, int begin, int count)throws SQLException;
	
	/**
	 * 通过id和count来得到News实体
	 * @param newsId
	 * @param count
	 * @return
	 */
	List<News> getNewsById(Connection connection, int newsId, int count) throws SQLException;
}
