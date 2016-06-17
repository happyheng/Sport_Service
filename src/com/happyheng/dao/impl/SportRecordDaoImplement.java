package com.happyheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.happyheng.dao.SportRecordDao;
import com.happyheng.entity.SportRecord;

public class SportRecordDaoImplement extends BaseDaoImplement implements SportRecordDao {

	@Override
	public int insertUserId(Connection connection, int userId) throws SQLException {

		PreparedStatement statement = connection.prepareCall("insert into tal_sport (userid) values(?)");

		statement.setInt(1, userId);
		statement.execute();

		PreparedStatement quertStatement = connection.prepareCall("select LAST_INSERT_ID()");

		ResultSet set = quertStatement.executeQuery();
		if (set.next()) {
			return set.getInt("LAST_INSERT_ID()");
		} else {
			return 0;
		}
	}

	@Override
	public void insert(Connection connection, SportRecord record) throws SQLException {
		PreparedStatement statement = connection
				.prepareCall("insert into tal_sport_message (sportId,posx,posy,stime,location) values(?)");

		statement.setInt(1, record.getSportId());
		statement.setFloat(2, record.getPosX());
		statement.setFloat(3, record.getPosY());
		statement.setLong(4, record.getTime());
		statement.setString(5, record.getLocation());

		statement.execute();
	}

	@Override
	public List<SportRecord> queryRecordList(Connection connection, int id) throws SQLException {

		return null;
	}

}
