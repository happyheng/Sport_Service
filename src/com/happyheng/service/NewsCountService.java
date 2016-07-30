package com.happyheng.service;

import com.happyheng.cache.NewsCountCache;

/**
 * 可以为读取文章的个数+1的Service
 * @author liuheng
 *
 */
public class NewsCountService extends BaseService {
	
	/**
	 * 得到对应文章的阅读数并将Count+1
	 * @param id
	 */
	public String addAndGetReadCount(String id) {
		NewsCountCache cache = new NewsCountCache();
		String readCount = "0";
		
		try {
			readCount = cache.getAndAddCountFromCache(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return readCount;
	}
}
