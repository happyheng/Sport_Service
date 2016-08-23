package com.happyheng.service.impl;

import java.sql.Connection;
import com.happyheng.dao.SportRecordDao;
import com.happyheng.entity.SportRecord;
import com.happyheng.service.SportRecordService;
import com.happyheng.utils.ConnectionFactory;

/**
 * 运动信息记录的逻辑处理类，负责将请求写入到数据库，并根据情况决定返回值
 * 
 * @author liuheng
 *
 */
public class SportRecordServiceImpl extends BaseService implements SportRecordService{
	
	private SportRecordDao recordDao;
	
	public SportRecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(SportRecordDao recordDao) {
		this.recordDao = recordDao;
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
	@Override
	public int record(int sportId, double posx, double posy, String location) {

		try {
			SportRecord record = new SportRecord();
			record.setSportId(sportId);
			record.setPosX(posx);
			record.setPosY(posy);
			record.setLocation(location);

			// 将运动信息写入
			recordDao.insert(record);
			return 0;

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return 100;
	}

}
