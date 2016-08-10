package com.happyheng.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.happyheng.entity.User;

public interface NewUserDao {
	
	/**
	 * 将User保存至数据库中
	 * @param user
	 */
	@Insert("insert into tal_user (name,password,nickname,token) values (#{name},#{password},#{nickname},#{token})")
	public void save(User user);
	
	/**
	 * 查询数据库中是否有对应的UserName，如果有，返回对应id，没有，返回0
	 * @param userName
	 * @return
	 */
	@Select("select id from tal_user where name = #{userName}")
	public int queryUserName(String userName);
	
	/**
	 * 根据User查询数据库中相应的id的password是否正确。如果正确，返回对应的id，否则返回0
	 * @param id
	 * @param password
	 * @return
	 */
	@Select("select id from tal_user where id=#{id} and password=#{password}")
	public int queryPassWord(int id, String password);
	
	
	/**
	 * 向指定Id的User中更新token
	 * @param userId
	 * @param token
	 */
	@Update("update tal_user set token=#{token} where id = #{userId}")
	public void updateToken(int userId, String token);
	
	/**
	 * 根据token获取到用户的id，如果没有，返回0
	 * @param token
	 * @return
	 */
	@Select("select id from tal_user where token = #{token}")
	public int getUserId(String token);
}
