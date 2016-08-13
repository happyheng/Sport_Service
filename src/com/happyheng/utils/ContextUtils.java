package com.happyheng.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextUtils {
	private static final String APPLICATION_XML = "applicationContext.xml";
	
	private static ApplicationContext context;
	
	public static ApplicationContext getContext(){
		if (context == null) {
			context = new ClassPathXmlApplicationContext(APPLICATION_XML);
		}
		return context;
	}
}
