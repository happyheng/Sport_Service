package com.happyheng.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.omg.CORBA.INTERNAL;

import com.happyheng.entity.Sport;
import com.happyheng.entity.SportRecord;

public interface SportRecordDao {
	
	/**
	 * 将userId插入到用户运动表中，获取自增的运动id
	 * @param connection
	 * @param userId  如果获取失败，返回0
	 * @return
	 * @throws SQLException
	 */
	@Insert("insert into tal_sport (userid) values (#{userid})")
	@SelectKey(statement = "select last_insert_id() as id", keyProperty = "id", before = false, resultType = long.class)
	public Integer insertSport(Sport sport) throws SQLException;
	

	/**
	 * 将SportRecord保存至数据库中
	 * 
	 * @param connection
	 * @param record
	 * @throws SQLException
	 */
	@Insert("insert into tal_sport_message (sportId,posx,posy,location) values(#{sportId},#{posX},#{posY},#{location})")
	public void insert(SportRecord record) throws SQLException;

	
	/**
	 * 根据用户的id获取对已经的运动的所有信息（关联表查询）
	 * @param connection
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@Select("select * from tal_sport_message where ")
	public List<SportRecord> queryRecordList(int id) throws SQLException;
	
	/**
	 * 根据用户的userKey查出用户的sportId
	 * @param userKey
	 * @return
	 * @throws SQLException
	 */
	@Select("select id from tal_sport where userid in (select id from tal_user where token = #{userKey})")
	public List<Integer> getSportList(String userKey) throws SQLException;
}
