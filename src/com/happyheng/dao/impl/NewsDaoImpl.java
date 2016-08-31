package com.happyheng.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.happyheng.dao.NewsDao;
import com.happyheng.entity.News;

public class NewsDaoImpl extends SqlSessionDaoSupport implements NewsDao {

	private static final String BASE_STATEMENT = "com.happyheng.mapper.NewsMapper.";

	@Override
	public List<News> getNewsByIndex(int begin, int count) throws SQLException {

		Map<String, Integer> map = new HashMap<>();
		map.put("begin", begin);
		map.put("count", count);

		return getSqlSession().selectList(BASE_STATEMENT + "selectNewsByIndex", map);
	}

	@Override
	public List<News> getNewsById(int newsId, int count) throws SQLException {
		Map<String, Integer> map = new HashMap<>();
		map.put("id", newsId);
		map.put("count", count);
		return getSqlSession().selectList(BASE_STATEMENT + "selectNewsById", map);
	}

}
