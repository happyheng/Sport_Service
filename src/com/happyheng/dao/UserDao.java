package com.happyheng.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.happyheng.entity.User;

public interface UserDao {
	/**
	 * 将User保存至数据库中
	 * 
	 * @param connection
	 * @param user
	 */
	public void save(Connection connection, User user) throws SQLException;

	/**
	 * 查询数据库中是否有对应的UserName，如果有，返回对应id，没有，返回0
	 * 
	 * @param connection
	 * @param userName
	 * @return
	 */
	public int queryUserName(Connection connection, String userName) throws SQLException;

	/**
	 * 根据User查询数据库中相应的id的password是否正确。如果正确，返回对应的id，否则返回0
	 * 
	 * @param connection
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int queryPassWord(Connection connection, int id, String password) throws SQLException;

	/**
	 * 向指定Id的User中更新token
	 * 
	 * @param connection
	 * @param userId
	 * @param token
	 * @throws SQLException
	 */
	public void updateToken(Connection connection, int userId, String token) throws SQLException;
	
	/**
	 * 根据token获取到用户的id，如果没有，返回0
	 * @param connection
	 * @param token
	 * @throws SQLException
	 */
	public int getUserId(Connection connection,  String token) throws SQLException;
	
	
	

}
