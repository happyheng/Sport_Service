package com.happyheng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happyheng.service.impl.NewsCountServiceImpl;

@WebServlet("/NewsDetail")
public class NewsDetailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3283222204004825080L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newsId = req.getParameter("id");

		NewsCountServiceImpl service = new NewsCountServiceImpl();
		String count = service.addAndGetReadCount(newsId);

		System.out.println("输出的结果为" + count);
	}

}
