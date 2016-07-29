package com.happyheng.utils;

import redis.clients.jedis.Jedis;

public class Redis {
	public static Jedis mJedis = null;

	public static Jedis getConnection() {
		if (mJedis == null) {
			mJedis = new Jedis("localhost");
		}
		return mJedis;
	}
	
}
