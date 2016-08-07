package com.happyheng.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.happyheng.entity.result.NewsResult;
import com.happyheng.service.NewsService;
import com.happyheng.service.impl.NewsCountServiceImpl;

@Controller
public class NewsController extends BaseController {
	public NewsController() {
		super();
	}

	@RequestMapping(value = "/News", method = RequestMethod.POST)
	public void getNews(HttpServletRequest req, HttpServletResponse resp) throws Exception {
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
	
	@RequestMapping(value = "/NewsDetail", method = RequestMethod.POST)
	public void getNewsDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String newsId = req.getParameter("id");

		NewsCountServiceImpl service = new NewsCountServiceImpl();
		String count = service.addAndGetReadCount(newsId);

		System.out.println("输出的结果为" + count);
	}
	
}
