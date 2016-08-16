package com.happyheng.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.happyheng.dao.SportRecordDao;
import com.happyheng.entity.Location;
import com.happyheng.entity.result.SportMessageResult;
import com.happyheng.service.SportMessageService;

public class SportMessageImpl extends BaseService implements SportMessageService {

	private SportRecordDao recordDao;

	public SportRecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(SportRecordDao recordDao) {
		this.recordDao = recordDao;
	}
	
	
	@Override
	public SportMessageResult getSportMessage(String userKey, String sportId) {
		
		SportMessageResult result = new SportMessageResult();
		
		try {
			List<Location> listData = recordDao.getSportMessage(sportId);
			
			if (listData != null && !listData.isEmpty()) {
				result.setResult(RESULT_CODE_SUCCESS);
				result.setData(listData);
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.setResult(RESULT_CODE_ERROR);
		return result;
	}

}
