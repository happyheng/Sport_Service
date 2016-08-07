package com.happyheng.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

	private Properties properties;

	public PropertiesUtils(String fileName) {

		properties = new Properties();

		try {
			InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream(fileName);
			properties.load(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getProperties(String propertiesName) {
		return properties.getProperty(propertiesName);
	}
}
