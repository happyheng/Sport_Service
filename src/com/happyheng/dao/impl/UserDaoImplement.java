package com.happyheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.happyheng.dao.UserDao;
import com.happyheng.entity.User;

public class UserDaoImplement extends BaseDaoImplement implements UserDao {

	@Override
	public void save(Connection connection, User user) throws SQLException {

		PreparedStatement statement = connection
				.prepareCall("insert into tal_user (name,password,nickname) values(?,?,?)");

		statement.setString(1, user.getName());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getNickname());

		statement.execute();
	}

	public int queryUserName(Connection connection, String userName) throws SQLException {

		PreparedStatement statement = connection.prepareCall("Select * from tal_user where name = ?");

		statement.setString(1, userName);
		
		ResultSet set = statement.executeQuery();
		// 下一个不为空，说明数据库中包含有此字段,则返回此条数据的id
		if (set.next()) {
			return set.getInt("id");
		} else {
			return 0;
		}

	}

	@Override
	public int queryPassWord(Connection connection, int id, String password) throws SQLException {

		PreparedStatement statement = connection.prepareCall("Select * from tal_user where id = ? and password = ?");

		statement.setInt(1, id);
		statement.setString(2, password);

		ResultSet set = statement.executeQuery();
		// 下一个不为空，说明数据库中包含有此字段,则返回此条数据的id
		if (set.next()) {
			return set.getInt("id");
		} else {
			return 0;
		}

	}

	@Override
	public void updateToken(Connection connection, int userId, String token) throws SQLException {
		PreparedStatement statement = connection.prepareCall("update tal_user set token =  ? where id = ?");

		statement.setString(1, token);
		statement.setInt(2, userId);

		statement.execute();
	}

}
