package com.happyheng.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.happyheng.dao.NewsDao;
import com.happyheng.entity.News;
import com.happyheng.entity.result.NewsResult;
import com.happyheng.service.NewsService;
import com.happyheng.utils.ConnectionFactory;

public class NewsServiceImpl extends BaseService implements NewsService{
	
	private NewsDao newsDao;
	
	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Override
	public NewsResult getNews(int begin, int id, int count) {
		NewsResult result = new NewsResult();
		//Connection connection = ConnectionFactory.getInstance().makeConnection();

		try {

			List<News> news;
			if (id != 0) {
				news = newsDao.getNewsById(id, count);
			} else {
				news = newsDao.getNewsByIndex(begin, count);
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
