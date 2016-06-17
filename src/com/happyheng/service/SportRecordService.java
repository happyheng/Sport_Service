package com.happyheng.service;

import java.sql.Connection;

import com.happyheng.dao.SportRecordDao;
import com.happyheng.dao.UserDao;
import com.happyheng.dao.impl.SportRecordDaoImplement;
import com.happyheng.dao.impl.UserDaoImplement;
import com.happyheng.entity.SportRecord;
import com.happyheng.utils.ConnectionFactory;

public class SportRecordService {

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
	public int record(String userKey, float posx, float posy, long time, String location) {
		
		Connection connection = null;
		connection = ConnectionFactory.getInstance().makeConnection();

		
		try {
			//1、先使用userKey得到对应的userId
			UserDao userDao = new UserDaoImplement();
			int userId = userDao.getUserId(connection, userKey);
			
			if (userId!=0) {

				//2、给Sport表中插入userId,获取sportId
				SportRecordDao recordDao = new SportRecordDaoImplement();
				int sportId = recordDao.insertUserId(connection, userId);
				
				if (sportId!=0) {
					System.out.println("得到的SportId为" + sportId);
					
					//3、根据sportId和运动数据，插入到sport_message表中
					int code = record(sportId, posx, posy, time, location);
					
					if (code == 0) {
						return sportId;
					}
				}
			}
			
		} catch (Exception e) {
			
		}
		
		return 0;
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
	public int record(int sportId, float posx, float posy, long time, String location) {

		Connection connection = null;
		connection = ConnectionFactory.getInstance().makeConnection();
		
		try {
			SportRecord record = new SportRecord();
			record.setSportId(sportId);
			record.setPosX(posx);
			record.setPosY(posy);
			record.setTime(time);
			record.setLocation(location);
			
			SportRecordDao recordDao = new SportRecordDaoImplement();
			recordDao.insert(connection, record);
			
			return 0;
			
		} catch (Exception e) {
			return 100;
		}

		
	}

	public static void main(String[] args) {
		
	}
}
