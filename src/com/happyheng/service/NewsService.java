package com.happyheng.service;

import com.happyheng.entity.result.NewsResult;

public interface NewsService {
	public NewsResult getNews(int begin, int id, int count);
}
