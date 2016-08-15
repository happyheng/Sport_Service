package com.happyheng.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.happyheng.dao.SportRecordDao;
import com.happyheng.entity.result.SportListResult;
import com.happyheng.service.SportListService;

public class SportListServiceImpl extends BaseService implements SportListService {

	private SportRecordDao recordDao;

	public SportRecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(SportRecordDao recordDao) {
		this.recordDao = recordDao;
	}

	@Override
	public SportListResult getSportList(String userKey) {

		SportListResult result = new SportListResult();

		try {
			List<Integer> list = recordDao.getSportList(userKey);
			if (list == null || list.isEmpty()) {
				result.setResult(RESULT_CODE_ERROR);
			} else {
				result.setResult(RESULT_CODE_SUCCESS);
				result.setData(list);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			result.setResult(RESULT_CODE_ERROR);
		}

		return result;
	}

}
