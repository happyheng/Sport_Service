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

@WebServlet("/News")
public class NewsServlet extends BaseServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int begin = requestJson.getIntValue("begin");
		int id = requestJson.getIntValue("id");
		int count = requestJson.getIntValue("count");
		
		NewsService service = new NewsService();
		NewsResult result = service.getNews(begin, id, count);
		
		String resultJson = JSON.toJSONString(result);
		
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(resultJson);
		printWriter.close();
	}
}
