package com.happyheng.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 连接数据库的工厂类
 * 
 * @author liuheng
 *
 */
public class ConnectionFactory {


	// 下面的四个成员变量用于保存从数据库中读取的配置信息
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;

	private static ConnectionFactory mConnectionFactory = new ConnectionFactory();

	private ConnectionFactory() {

	}

	//使用静态代码块来初始化四个配置信息
	static {

		Properties properties = new Properties();

		try {
			InputStream inputStream = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			properties.load(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");
		dburl = properties.getProperty("dburl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}
	
	//获取ConnectionFactory单例
	public static ConnectionFactory getInstance() {
		return mConnectionFactory;
	}
	
	private Connection mConnection;
	
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			mConnection = DriverManager.getConnection(dburl, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mConnection;
	}

}
