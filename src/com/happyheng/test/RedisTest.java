package com.happyheng.test;

import com.happyheng.entity.News;
import com.happyheng.entity.result.NewsResult;
import com.happyheng.service.NewsService;
import com.happyheng.utils.Redis;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		// // 连接本地的 Redis 服务
		// Jedis jedis = Redis.getConnection();
		// System.out.println("Connection to server sucessfully");
		// // 查看服务是否运行
		// System.out.println("Server is running: " + jedis.ping());
		//
		// jedis.set("bar", "1");
		// String result = jedis.get("bar");
		// System.out.println("存储的结果为"+result);

		NewsService service = new NewsService();
		NewsResult result = service.getNews(1, 0, 10);
		
		for (News news : result.getData()) {
			System.out.println("得到的结果为"+news);
		}
	}

}
