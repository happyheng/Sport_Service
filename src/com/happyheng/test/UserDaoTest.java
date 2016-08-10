package com.happyheng.test;

import org.apache.ibatis.session.SqlSession;

import com.happyheng.dao.NewUserDao;
import com.happyheng.entity.User;
import com.happyheng.utils.MyBatisUtil;

public class UserDaoTest {

	public static void main(String[] args) {
		testSave();
	}
	
	public static void testSave() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		NewUserDao dao = session.getMapper(NewUserDao.class);
		
		User user = new User();
		user.setName("liuheng789");
		user.setPassword("123456");
		user.setNickname("lalalalala");
		
		dao.save(user);
		session.close();
	}

}
