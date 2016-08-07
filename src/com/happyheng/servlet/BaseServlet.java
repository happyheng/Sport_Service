package com.happyheng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 所有HttpServlet的基类，
 * @author liuheng
 *
 */
public class BaseServlet extends HttpServlet {
	
	protected static final String RESULT_KEY = "result";
	private static final String APPLICATION_XML = "applicationContext.xml";

	protected ApplicationContext context;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		context = new ClassPathXmlApplicationContext(APPLICATION_XML);
	}
}
