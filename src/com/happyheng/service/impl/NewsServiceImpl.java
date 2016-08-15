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
	
	public static final String BASE_NEWS_URL = "http://www.happyheng.top:8080/Sport/NewsDetail?id=";
	
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

			List<News> newsList;
			if (id != 0) {
				newsList = newsDao.getNewsById(id, count);
			} else {
				newsList = newsDao.getNewsByIndex(begin, count);
			}
			
			//为所有的news添加url
			for(News news:newsList){
				news.setUrl(BASE_NEWS_URL+news.getId());
			}
			
			result.setCode(RESULT_CODE_SUCCESS);
			result.setData(newsList);
		} catch (SQLException e) {
			result.setCode(RESULT_CODE_ERROR);
			e.printStackTrace();
		}
		return result;
	}
}
