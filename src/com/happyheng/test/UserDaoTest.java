package com.happyheng.test;

import org.apache.ibatis.session.SqlSession;

import com.happyheng.dao.UserDao;
import com.happyheng.entity.User;
import com.happyheng.utils.MyBatisUtil;

public class UserDaoTest {

	public static void main(String[] args) {
		// testSave();
		//testQueryUserName();
		//testQueryPassword();
		//testUpdateToken();
		testGetUserId();
	}

	public static void testSave() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		UserDao dao = session.getMapper(UserDao.class);

		User user = new User();
		user.setName("liuheng789");
		user.setPassword("123456");
		user.setNickname("lalalalala");

		dao.save(user);
		session.close();
	}

	public static void testQueryUserName() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		UserDao dao = session.getMapper(UserDao.class);

		Integer id = dao.queryUserName("liuheng");
		if (id != null) {
			System.out.println("查询的id为" + id);
		} else {
			System.out.println("为空");
		}
		session.close();
	}
	
	public static void testQueryPassword() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		UserDao dao = session.getMapper(UserDao.class);
		
		Integer id = dao.queryPassWord(1, "123456");
		if (id != null) {
			System.out.println("查询的id为" + id);
		} else {
			System.out.println("为空");
		}
		session.close();
	}
	
	public static void testUpdateToken() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		UserDao dao = session.getMapper(UserDao.class);
		
		Integer result = dao.updateToken(1, "1_1470576360275");
		System.out.println("影响的条数为"+result);
	}
	
	public static void testGetUserId() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		UserDao dao = session.getMapper(UserDao.class);
		
		Integer id = dao.getUserId("2_1470575831125");
		if (id != null) {
			System.out.println("查询的结果为"+id);
		} else {
			System.out.println("结果为空");
		}
		session.close();
	}

}
