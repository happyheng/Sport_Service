package com.happyheng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.happyheng.entity.News;

public interface NewsDao {
	
	/**
	 * 通过开始位置和count来得到News实体
	 * @param begin
	 * @param count
	 * @return
	 */
	@Select("select * from tal_news order by id limit #{1} offset #{0}")
	List<News> getNewsByIndex(int begin, int count)throws SQLException;
	
	/**
	 * 通过id和count来得到News实体
	 * @param newsId
	 * @param count
	 * @return
	 */
	@Select("select * from tal_news where id > #{0} limit #{1}")
	List<News> getNewsById(int newsId, int count) throws SQLException;
	
	
}
