package com.happyheng.service;

import java.sql.Connection;

import com.happyheng.dao.SportRecordDao;
import com.happyheng.dao.UserDao;
import com.happyheng.dao.impl.SportRecordDaoImplement;
import com.happyheng.dao.impl.UserDaoImplement;
import com.happyheng.entity.result.SportRecordResult;
import com.happyheng.utils.ConnectionFactory;

public class SportIdService extends BaseService {

	public SportRecordResult getSportId(String userKey) {
		Connection connection = null;
		connection = ConnectionFactory.getInstance().makeConnection();

		SportRecordResult recordResult = new SportRecordResult();

		try {

			// 1、先使用userKey得到对应的userId
			UserDao userDao = new UserDaoImplement();
			int userId = userDao.getUserId(connection, userKey);

			if (userId != 0) {
				// 2、给Sport表中插入userId,获取sportId
				SportRecordDao recordDao = new SportRecordDaoImplement();
				int sportId = recordDao.insertUserId(connection, userId);
				
				recordResult.setCode(RESULT_CODE_SUCCESS);
				recordResult.setSportId(sportId);
				return recordResult;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		recordResult.setCode(RESULT_CODE_ERROR);
		return recordResult;
	}
}
