package com.happyheng.service.impl;

import com.happyheng.dao.SportRecordDao;
import com.happyheng.dao.UserDao;
import com.happyheng.entity.Sport;
import com.happyheng.entity.result.SportRecordResult;
import com.happyheng.service.SportIdService;

public class SportIdServiceImpl extends BaseService implements SportIdService {

	private UserDao userDao;
	private SportRecordDao recordDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public SportRecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(SportRecordDao recordDao) {
		this.recordDao = recordDao;
	}

	@Override
	public SportRecordResult getSportId(String userKey) {
		// Connection connection = null;
		// connection = ConnectionFactory.getInstance().makeConnection();

		SportRecordResult recordResult = new SportRecordResult();

		try {

			// 1、先使用userKey得到对应的userId
			Integer userId = userDao.getUserId(userKey);

			if (userId != null) {
				// 2、给Sport表中插入userId,获取sportId
				Sport sport = new Sport();
				sport.setUserid(userId);
				Integer insertSportResult = recordDao.insertSport(sport);

				if (insertSportResult != null) {
					recordResult.setCode(RESULT_CODE_SUCCESS);
					recordResult.setSportId(sport.getId());
					return recordResult;
				}

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		recordResult.setCode(RESULT_CODE_ERROR);
		return recordResult;
	}
}
