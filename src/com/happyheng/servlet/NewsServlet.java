package com.happyheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.happyheng.entity.result.NewsResult;
import com.happyheng.service.NewsService;
import com.happyheng.service.impl.NewsServiceImpl;

@WebServlet("/News")
public class NewsServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3446965709620576149L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int begin = 0;
		int id = 0;
		if (req.getAttribute("begin") != null) {
			begin = (int) req.getAttribute("begin");
		}
		if (req.getAttribute("id") != null) {
			id = (int) req.getAttribute("id");
		}

		int count = (int) req.getAttribute("count");

		NewsService service = (NewsService) context.getBean("newsService");
		NewsResult result = service.getNews(begin, id, count);

		String resultJson = JSON.toJSONString(result);

		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(resultJson);
		printWriter.close();
	}
}
