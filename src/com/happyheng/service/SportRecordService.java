package com.happyheng.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.happyheng.dao.SportRecordDao;
import com.happyheng.dao.UserDao;
import com.happyheng.dao.impl.SportRecordDaoImplement;
import com.happyheng.dao.impl.UserDaoImplement;
import com.happyheng.entity.SportRecord;
import com.happyheng.entity.result.SportRecordResult;
import com.happyheng.utils.ConnectionFactory;

/**
 * 运动信息记录的逻辑处理类，负责将请求写入到数据库，并根据情况决定返回值
 * 
 * @author liuheng
 *
 */
public class SportRecordService extends BaseService {

	/**
	 * 根据userKey，先获取userId,然后插入到运动表中，获取运动id，然后在将所有的信息插入进去
	 * 
	 * @param userKey
	 * @param posx
	 * @param posy
	 * @param time
	 * @param location
	 * @return
	 */
	public SportRecordResult record(String userKey, float posx, float posy, String location) {

		Connection connection = null;
		connection = ConnectionFactory.getInstance().makeConnection();

		SportRecordResult recordResult = new SportRecordResult();
		try {
			// 注意需要使用事务，如果中间出现失败，那么进行回滚
			connection.setAutoCommit(false);

			// 1、先使用userKey得到对应的userId
			UserDao userDao = new UserDaoImplement();
			int userId = userDao.getUserId(connection, userKey);

			if (userId != 0) {

				// 2、给Sport表中插入userId,获取sportId
				SportRecordDao recordDao = new SportRecordDaoImplement();
				int sportId = recordDao.insertUserId(connection, userId);

				if (sportId != 0) {
					System.out.println("得到的SportId为" + sportId);

					SportRecord record = new SportRecord();
					record.setSportId(sportId);
					record.setPosX(posx);
					record.setPosY(posy);
					record.setLocation(location);
					// 3、根据sportId和运动数据，插入到sport_message表中
					recordDao.insert(connection, record);
					
					connection.commit();

					// 4、没有错误出现即插入成功，才算成功
					recordResult.setCode(RESULT_CODE_SUCCESS);
					recordResult.setSportId(sportId);

					return recordResult;

				}
			}

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		recordResult.setCode(RESULT_CODE_ERROR);
		return recordResult;
	}

	/**
	 * 根据运动的信息及其id，插入到运动信息表中。
	 * 
	 * @param sportId
	 * @param posx
	 * @param posy
	 * @param time
	 * @param location
	 */
	public int record(int sportId, float posx, float posy, String location) {

		Connection connection = null;
		connection = ConnectionFactory.getInstance().makeConnection();

		try {
			SportRecord record = new SportRecord();
			record.setSportId(sportId);
			record.setPosX(posx);
			record.setPosY(posy);
			record.setLocation(location);

			SportRecordDao recordDao = new SportRecordDaoImplement();
			// 将运动信息写入
			recordDao.insert(connection, record);

			return 0;

		} catch (Exception e) {
			e.printStackTrace();
			return 100;
		}

	}

}
