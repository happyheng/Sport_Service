package com.happyheng.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.happyheng.entity.User;

public interface UserDao {
	
	/**
	 * 将User保存至数据库中
	 * @param user
	 */
	@Insert("insert into tal_user (name,password,nickname) values (#{name},#{password},#{nickname})")
	public void save(User user);
	
	/**
	 * 查询数据库中是否有对应的UserName，如果有，返回对应id，没有，返回0
	 * @param userName
	 * @return
	 */
	@Select("select id from tal_user where name = #{userName}")
	public Integer queryUserName(String userName);
	
	/**
	 * 根据User查询数据库中相应的id的password是否正确。如果正确，返回对应的id，否则返回0
	 * @param id
	 * @param password
	 * @return
	 */
	@Select("select id from tal_user where id=#{0} and password=#{1}")
	public Integer queryPassWord(int id, String password);
	
	
	/**
	 * 向指定Id的User中更新token
	 * @param userId
	 * @param token
	 */
	@Update("update tal_user set token=#{1} where id = #{0}")
	public int updateToken(int userId, String token);
	
	/**
	 * 根据token获取到用户的id，如果没有，返回0
	 * @param token
	 * @return
	 */
	@Select("select id from tal_user where token = #{token}")
	public Integer getUserId(String token);
}
