package com.happyheng.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.happyheng.dao.NewsDao;
import com.happyheng.entity.News;
import com.happyheng.utils.Redis;

import redis.clients.jedis.Jedis;

public class NewsDaoRedisImplement implements NewsDao {

	// 默认缓存的条数
	public static final int CACHE_NUM = 100;
	// 缓存的有序列表Key
	public static final String KEY_LIST = "article_list";

	private Jedis mJedis;

	public NewsDaoRedisImplement() {
		mJedis = Redis.getConnection();
	}

	@Override
	public List<News> getNewsByIndex(Connection connection, int begin, int count) throws SQLException {

		// 1、判断数据是否存在，不存在即填充
		initData(connection);

		// 2、然后取出
		List<News> result = getNewsByIndexFromRedis(begin, count);
		return result;
	}

	@Override
	public List<News> getNewsById(Connection connection, int newsId, int count) throws SQLException {
		// 1、判断数据是否存在，不存在即填充
		initData(connection);

		// 2、然后取出
		List<News> result = getNewsByIdFromRedis(newsId, count);
		return result;
	}

	private void initData(Connection connection) throws SQLException {
		// 1、首先判断缓存中是否有，如果有，就直接返回
		boolean isExist = mJedis.exists(KEY_LIST);

		if (!isExist) {
			// 2、如果没有，从数据库中取出，并缓存至Redis中
			getDataFromRedis(connection);
		} else {
			System.out.println("Redis中存在数据");
		}
	}

	private void getDataFromRedis(Connection connection) throws SQLException {
		NewsDao dbDao = new NewsDaoImplement();
		List<News> list = dbDao.getNewsByIndex(connection, 0, CACHE_NUM);
		for (News news : list) {
			mJedis.zadd(KEY_LIST, news.getId(), JSON.toJSONString(news));
		}
	}

	private List<News> getNewsByIndexFromRedis(int begin, int count) {
		List<News> newList = new ArrayList<>();
		Set<String> result = mJedis.zrange(KEY_LIST, begin, begin + count - 1);

		for (String newsJson : result) {
			News news = JSON.parseObject(newsJson, News.class);
			newList.add(news);
		}
		return newList;
	}

	private List<News> getNewsByIdFromRedis(int newsId, int count) {
		List<News> newList = new ArrayList<>();
		Set<String> result = mJedis.zrangeByScore(KEY_LIST, String.valueOf(newsId), "+inf", 0, count);

		for (String newsJson : result) {
			News news = JSON.parseObject(newsJson, News.class);
			newList.add(news);
		}
		return newList;
	}

}
