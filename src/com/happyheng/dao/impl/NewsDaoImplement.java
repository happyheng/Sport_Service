package com.happyheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.happyheng.dao.NewsDao;
import com.happyheng.entity.News;

public class NewsDaoImplement 
//implements NewsDao 
{

//	@Override
//	public List<News> getNewsByIndex(Connection connection, int begin, int count) throws SQLException{
//		
//		
//		PreparedStatement statement = connection.prepareCall("select * from tal_news order by id limit ? offset ?");
//		statement.setInt(1, count);
//		statement.setInt(2, begin);
//		
//		List<News> newsList = getNewsFromResultSet(statement.executeQuery());
//		return newsList;
//	}
//
//	@Override
//	public List<News> getNewsById(Connection connection, int newsId, int count) throws SQLException{
//		PreparedStatement statement = connection.prepareCall("select * from tal_news where id > ? limit ?");
//		statement.setInt(1, newsId);
//		statement.setInt(2, count);
//		
//		List<News> newsList = getNewsFromResultSet(statement.executeQuery());
//		return newsList;
//	}
//
//	public List<News> getNewsFromResultSet(ResultSet set) throws SQLException{
//		
//		List<News> newsList = new ArrayList<>();
//		
//		while(set.next()){
//			News news = new News();
//			news.setId(set.getLong("id"));
//			news.setName(set.getString("name"));
//			news.setSimplecontent(set.getString("simplecontent"));
//			news.setThumbnail(set.getString("thumbnail"));
//			news.setUrl(set.getString("url"));
//			
//			newsList.add(news);
//		}
//		
//		return newsList;
//	}


}
