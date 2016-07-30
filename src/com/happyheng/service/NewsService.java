package com.happyheng.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.happyheng.dao.NewsDao;
import com.happyheng.dao.impl.NewsDaoRedisImplement;
import com.happyheng.entity.News;
import com.happyheng.entity.result.NewsResult;
import com.happyheng.utils.ConnectionFactory;

public class NewsService extends BaseService {

	public NewsResult getNews(int begin, int id, int count) {
		NewsResult result = new NewsResult();
		NewsDao newsDao = new NewsDaoRedisImplement();

		Connection connection = ConnectionFactory.getInstance().makeConnection();

		try {

			List<News> news;
			if (id != 0) {
				news = newsDao.getNewsById(connection, id, count);
			} else {
				news = newsDao.getNewsByIndex(connection, begin, count);
			}
			
			result.setCode(RESULT_CODE_SUCCESS);
			result.setData(news);
		} catch (SQLException e) {
			result.setCode(RESULT_CODE_ERROR);
			e.printStackTrace();
		}
		return result;
	}
}
